package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

import java.util.Collection;
import java.util.Map;

public class Bishop extends ChessFigure {
    public Bishop(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        return Math.abs(coordinateFrom.getX()-coordinateTo.getX()) == Math.abs(coordinateFrom.getY()-coordinateTo.getY());
    }

    public boolean is_shah(Map<String, String> value_of_figure, Collection<String> black_figure, Collection<String> white_figure){
        boolean is_shah_ = false;
        int king_x;
        int king_y;
        if(colorIsWhite){
            king_x = Integer.parseInt(value_of_figure.get("black_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("black_king").substring(2));

        } else{
            king_x = Integer.parseInt(value_of_figure.get("white_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("white_king").substring(2));
        }
        int bishop_x = coordinateFrom.getX();
        int bishop_y = coordinateFrom.getY();
        int max_coordinate_x = Math.max(bishop_x, king_x);
        int max_coordinate_y = Math.max(bishop_y, king_y);
        int min_coordinate_x = Math.min(bishop_x, king_x);
        int min_coordinate_y = Math.min(bishop_y, king_y);
        if(Math.abs(king_x - bishop_x) == Math.abs(king_y - bishop_y)){
            while (max_coordinate_x > min_coordinate_x
                    && is_empty(max_coordinate_x, max_coordinate_y, black_figure)
                    && is_empty(max_coordinate_x, min_coordinate_y, white_figure)){
                if(max_coordinate_x == king_x && max_coordinate_y == king_y){
                    is_shah_ = true;
                    break;
                }
                max_coordinate_x -= 1;
                max_coordinate_y -= 1;
            }
        }
        return is_shah_;
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

    public Map<String, String> is_can_kill(String end_x, String end_y, Map<String, String> figure_list){
        for (Map.Entry<String, String> entry : figure_list.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if((end_x + " " + end_y).equals(v) && !k.substring(6).equals("king")){
                System.out.println("Вы срубили чужую фигуру " + k);
                figure_list.remove(k);
                return figure_list;
            }
        }
        return null;
    }
}
