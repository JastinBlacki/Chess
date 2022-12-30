package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

import java.util.Collection;
import java.util.Map;

public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2656' : '\u265c', coordinateFrom);
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
        return (coordinateFrom.getX() == coordinateTo.getX()) | (coordinateFrom.getY() == coordinateTo.getY());
    }

    public boolean is_shah(Map<String, String> value_of_figure, Collection<String> black_figure, Collection<String> white_figure){
        int position_king_x;
        int position_king_y;
        if(colorIsWhite){
            position_king_x = Integer.parseInt(value_of_figure.get("black_king").substring(0, 1));
            position_king_y = Integer.parseInt(value_of_figure.get("black_king").substring(2));
        } else{
            position_king_x = Integer.parseInt(value_of_figure.get("white_king").substring(0, 1));
            position_king_y = Integer.parseInt(value_of_figure.get("white_king").substring(2));
        }
        int position_rook_x = coordinateFrom.getX();
        int position_rook_y = coordinateFrom.getY();
        int max_coordinate_x = Math.max(position_rook_x, position_king_x);
        int max_coordinate_y = Math.max(position_rook_y, position_king_y);
        int min_coordinate_x = Math.min(position_rook_x, position_king_x);
        int min_coordinate_y = Math.min(position_rook_y, position_king_y);
        if(position_rook_x == position_king_x){
            while(max_coordinate_y >= min_coordinate_y && is_empty(max_coordinate_x, max_coordinate_y, black_figure)){
                if(max_coordinate_y == position_king_y) return true;
                max_coordinate_y -= 1;
            }
        } else if (position_rook_y == position_king_y) {
            while(max_coordinate_x >= min_coordinate_x && is_empty(max_coordinate_x, max_coordinate_y, black_figure)){
                if(max_coordinate_x == position_king_x) return true;
                max_coordinate_x -= 1;
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

    public boolean move
            (boolean is_x_equal_begin_x, int begin_x, int begin_y, int x, int y,
             Collection<String> figure) {
        int max_, min_;
        boolean is_move = true;
        if (is_x_equal_begin_x) {
            max_ = Math.max(y, begin_y);
            min_ = Math.min(y, begin_y);
            while (max_ > min_) {
                is_move = (is_empty_(x, max_, figure));
                max_ -= 1;
            }
        } else {
            max_ = Math.max(x, begin_x);
            min_ = Math.min(x, begin_x);
            while (max_ > min_) {
                is_move = (is_empty_(max_, y, figure));
                max_ -= 1;
            }
        }
        return is_move;
    }

    public Map<String, String> is_can_kill(String end_x, String end_y, Map<String, String> figure_list){
        for (Map.Entry<String, String> entry : figure_list.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if((end_x + " " + end_y).equals(v) && !k.substring(6).equals("king")){
                System.out.println("Вы срубили чужую фигуру " + k);
                figure_list.remove(k);
                break;
            }
        }
        return figure_list;
    }
}
