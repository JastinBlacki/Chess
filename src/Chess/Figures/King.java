package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends ChessFigure {
    public King(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2654' : '\u265a', coordinateFrom);
    }

    private boolean is_empty(int x, int y, Collection<String> figure_list){
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
        return ((coordinateFrom.getX() - coordinateTo.getX() == 0) | Math.abs(coordinateFrom.getX() - coordinateTo.getX()) == 1)
             & ((coordinateFrom.getY() - coordinateTo.getY() == 0) | Math.abs(coordinateFrom.getY() - coordinateTo.getY()) == 1);
    }

    // TODO: ОПРЕДЕЛИТЬ/ПОЛУЧИТЬ ИНФОРМАЦИЮ О ФИГУРЕ, КОТОРАЯ СТАВИТ ШАХ можно ли ее срубить другой фигурой? Если можно, то срубить
    //  Королем нельзя срубить не при каком раскладе
    // TODO: РОКИРОВКА ДЛИННАЯ И КОРОТКАЯ
    public List<String> is_mat(int x, int y, Collection<String> black_figure, Collection<String> white_figure){
        List<String> coordinate_x = new ArrayList<String>();
        List<String> coordinate_y = new ArrayList<String>();
        List<String> empty = new ArrayList<String>();
        boolean is_move;
        coordinate_x.add(String.valueOf(x));
        if(x - 1 > 0) coordinate_x.add(String.valueOf(x-1));
        if(x + 1 <= 8) coordinate_x.add(String.valueOf(x+1));
        if(y - 1 > 0) coordinate_y.add(String.valueOf(y-1));
        if(y + 1 <= 8) coordinate_y.add(String.valueOf(y+1));
        for (String x_item:coordinate_x) {
            for (String y_item:coordinate_y){
                is_move = is_empty(Integer.parseInt(x_item), Integer.parseInt(y_item), black_figure)
                        && is_empty(Integer.parseInt(x_item), Integer.parseInt(y_item), white_figure);
                if(is_move) empty.add(x_item + " " + y_item);
            }
        }
        return empty;
    }
}
