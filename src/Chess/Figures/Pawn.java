package Chess.Figures;

import Chess.Base.Coordinate;
import Chess.ChessFigure;

import java.util.Collection;
import java.util.Map;

public class Pawn extends ChessFigure {

    boolean isFirstStep;

    private static boolean is_empty_(int x, int y, Collection<String> figure_list){
        for (String t:figure_list) {
            if((x + " " + y).equals(t)){
                System.out.println("Ход невозможен, так как на клетке " + x + " " + y + " стоит фигура");
                return false;
            }
        }
        return true;
    }

    public Pawn(boolean colorIsWhite, Coordinate coordinate) {
        super(colorIsWhite, colorIsWhite ? '\u2659' : '\u265f', coordinate);
        this.isFirstStep = true;
    }


    @Override
    public boolean canMove(Coordinate coordinateTo) {
        if (colorIsWhite) {
            if (isFirstStep) {
                if (coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateTo.getY() - coordinateFrom.getY() == 2
                        || coordinateTo.getY() - coordinateFrom.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;

            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateTo.getY() - coordinateFrom.getY() == 1;
            }
        } else {
            if (isFirstStep) {
                if (coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateFrom.getY() - coordinateTo.getY() == 2
                        || coordinateFrom.getY() - coordinateTo.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;
            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateFrom.getY() - coordinateTo.getY() == 1;
            }
        }
    }

    public Map<String, String> is_can_kill(int x, int y, int x_from, int y_from, Map<String, String> figure_list){
        boolean j = Math.abs(x - x_from) == 1;
        boolean is_can_kill = false;
        if(colorIsWhite) {
            if (j && (y - y_from == 1)) {
                is_can_kill = true;
            }
        } else {
            if (j && (y_from - y == 1)) {
                is_can_kill = true;
            }
        }
        if(is_can_kill){
            for (Map.Entry<String, String> entry : figure_list.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                if((String.valueOf(x) + " " + String.valueOf(y)).equals(v)){
                    System.out.println("Вы срубили чужую фигуру " + k);
                    figure_list.remove(k);
                    return figure_list;
                }
            }

        }
        return null;
    }

    public boolean is_shah(Map<String, String> value_of_figure){
        if(colorIsWhite){
            int position_king_x = Integer.parseInt(value_of_figure.get("black_king").substring(0, 1));
            int position_king_y = Integer.parseInt(value_of_figure.get("black_king").substring(2));
            return Math.abs(coordinateFrom.getX() - position_king_x) == 1 && (position_king_y - coordinateFrom.getY() == 1);
        } else{
            int position_king_x = Integer.parseInt(value_of_figure.get("white_king").substring(0, 1));
            int position_king_y = Integer.parseInt(value_of_figure.get("white_king").substring(2));
            return Math.abs(coordinateFrom.getX() - position_king_x) == 1 && (coordinateFrom.getY() - position_king_y == 1);
        }
    }

    public boolean move(int max_, int min_, int x, Collection<String> figure_list){
        boolean is_move = true;
        while (max_ > min_) {
            is_move = is_empty_(x, max_, figure_list);
            max_ -= 1;
        }
        return is_move;
    }
}