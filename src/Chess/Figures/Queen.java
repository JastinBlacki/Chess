package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

import java.util.Collection;
import java.util.Map;

public class Queen extends ChessFigure {
    public Queen(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b', coordinateFrom);
    }

    private static boolean is_empty_(int x, int y, Collection<String> figure_list){
        for (String t:figure_list) {
            if((x + " " + y).equals(t)){
                System.out.println("Ход невозможен, так как на клетке " + x + " " + y + " стоит фигура");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        return ((coordinateFrom.getX() == coordinateTo.getX()) | (coordinateFrom.getY() == coordinateTo.getY())) |
            Math.abs(coordinateFrom.getX()-coordinateTo.getX()) == Math.abs(coordinateFrom.getY()-coordinateTo.getY());
    }

    public boolean is_shah(Map<String, String> value_of_figure, Collection<String> black_figure, Collection<String> white_figure){
        int king_x;
        int king_y;
        if(colorIsWhite){
            king_x = Integer.parseInt(value_of_figure.get("black_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("black_king").substring(2));
        } else{
            king_x = Integer.parseInt(value_of_figure.get("white_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("white_king").substring(2));
        }
        int queen_x = coordinateFrom.getX();
        int queen_y = coordinateFrom.getY();
        int max_coordinate_x = Math.max(queen_x, king_x);
        int max_coordinate_y = Math.max(queen_y, king_y);
        int min_coordinate_x = Math.min(queen_x, king_x);
        int min_coordinate_y = Math.min(queen_y, king_y);
        if((king_x == queen_x) || (king_y == queen_y)){
            if(queen_x == king_x){
                while(max_coordinate_y >= min_coordinate_y && is_empty(max_coordinate_x, max_coordinate_y, black_figure)){
                    if(max_coordinate_y == king_y){
                        return true;
                    }
                    max_coordinate_y -= 1;
                }
            } else{
                while(max_coordinate_x >= min_coordinate_x && is_empty(max_coordinate_x, max_coordinate_y, black_figure)){
                    if(max_coordinate_x == king_x){
                        return true;
                    }
                    max_coordinate_x -= 1;
                }
            }
            return false;
        } else {
            if(Math.abs(king_x - queen_x) == Math.abs(king_y - queen_y)){
                while (max_coordinate_x > min_coordinate_x
                        && is_empty(max_coordinate_x, max_coordinate_y, black_figure)
                        && is_empty(max_coordinate_x, min_coordinate_y, white_figure)){
                    if(max_coordinate_x == king_x && max_coordinate_y == king_y){
                        return true;
                    }
                    max_coordinate_x -= 1;
                    max_coordinate_y -= 1;
                }
            }
        }
        return false;
    }
    private boolean is_empty(int x, int y, Collection<String> figure_list){
        if(colorIsWhite){
            figure_list.remove("white_king");
        } else{
            figure_list.remove("black_king");
        }
        for (String t:figure_list) {
            if((x + " " + y).equals(t)){
                System.out.println("Ход невозможен, так как на клетке " + x + " " + y + " стоит фигура");
                return false;
            }
        }
        return true;
    }

    public boolean move(int x, int y, Collection<String> black_figure, Collection<String> white_figure,
                        int begin_x, int begin_y){
        int max_;
        int min_;
        boolean is_x_equal_begin_x;
        boolean is_move = false;
        is_x_equal_begin_x = x == begin_x;
        if (is_x_equal_begin_x) {
            max_ = Math.max(y, begin_y);
            min_ = Math.min(y, begin_y);
        } else {
            max_ = Math.max(x, begin_x);
            min_ = Math.min(x, begin_x);
        }
        while (max_ > min_) {
            is_move = (is_empty_(x, max_, white_figure) && is_empty_(max_, y, white_figure))
                    & (is_empty_(x, max_, black_figure) && is_empty_(max_, y, black_figure));
            max_ -= 1;
        }
        return is_move;
    }

    public Map<String, String> is_can_kill(int x, int y, Map<String, String> figure_list){
        for (Map.Entry<String, String> entry : figure_list.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if((x + " " + y).equals(v) && !k.substring(6).equals("king")){
                System.out.println("Вы срубили чужую фигуру " + k);
                figure_list.remove(k);
                return figure_list;
            }
        }
        return null;
    }
}
