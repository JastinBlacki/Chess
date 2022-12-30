package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

import java.util.Collection;
import java.util.Map;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        return (Math.abs(coordinateFrom.getX() - coordinateTo.getX()) == 1 &
                Math.abs(coordinateFrom.getY() - coordinateTo.getY()) == 2) |
               (Math.abs(coordinateFrom.getX() - coordinateTo.getX()) == 2 &
                Math.abs(coordinateFrom.getY() - coordinateTo.getY()) == 1);
    }

    public boolean is_shah(Map<String, String> value_of_figure, Collection<String> black_figure, Collection<String> white_figure){
        int knight_x = coordinateFrom.getX();
        int knight_y = coordinateFrom.getY();
        int king_x;
        int king_y;
        if(colorIsWhite){
            king_x = Integer.parseInt(value_of_figure.get("black_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("black_king").substring(2));
        } else{
            king_x = Integer.parseInt(value_of_figure.get("white_king").substring(0, 1));
            king_y = Integer.parseInt(value_of_figure.get("white_king").substring(2));
        }
        return (knight_x - 2 == king_x && knight_y + 1 == king_y) || (knight_x + 2 == king_x && knight_y + 1 == king_y)
                || (knight_x - 2 == king_x && knight_y - 1 == king_y) || (knight_x + 2 == king_x && knight_y - 1 == king_y)
                || (knight_x - 1 == king_x && knight_y + 2 == king_y) || (knight_x + 1 == king_x && knight_y + 2 == king_y)
                || (knight_x - 1 == king_x && knight_y - 2 == king_y) || (knight_x + 1 == king_x && knight_y - 2 == king_y);

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
