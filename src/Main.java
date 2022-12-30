import Chess.Base.Coordinate;
import Chess.ChessFigure;
import Chess.Figures.*;

import java.util.*;

public class Main {
    private static boolean is_empty_(int x, int y, Collection<String> figure_list) {
        for (String t : figure_list) {
            if ((x + " " + y).equals(t)) {
                System.out.println("Ход невозможен, так как на клетке " + x + " " + y + " стоит фигура");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Pawn black_pawn1, black_pawn2, black_pawn3, black_pawn4, black_pawn5, black_pawn6, black_pawn7, black_pawn8;
        Pawn obj_pawn;
        Rook obj_rook;
        Knight obj_knight;
        Bishop obj_bishop;
        Pawn white_pawn1, white_pawn2, white_pawn3, white_pawn4, white_pawn5, white_pawn6, white_pawn7, white_pawn8;
        Rook black_rook1, black_rook2, white_rook1, white_rook2;
        Bishop black_bishop1, black_bishop2, white_bishop1, white_bishop2;
        Knight black_knight1, black_knight2, white_knight1, white_knight2;
        Queen black_queen, white_queen;
        King white_king, black_king;
        boolean is_shah_white = false, is_shah_black = false, is_play_continue = true;
        int count_ = 0;
        String mat_figure;
        int max_x, min_x, max_y;

        int x, y;
        Scanner sc = new Scanner(System.in);
        String figure;
        Coordinate goTo1;
        Map<String, String> figure_and_place_white = new HashMap<String, String>();
        Map<String, String> figure_and_place_black = new HashMap<String, String>();

        white_pawn1 = new Pawn(true, new Coordinate(1, 2));
        white_pawn2 = new Pawn(true, new Coordinate(2, 2));
        white_pawn3 = new Pawn(true, new Coordinate(3, 2));
        white_pawn4 = new Pawn(true, new Coordinate(4, 2));
        white_pawn5 = new Pawn(true, new Coordinate(5, 2));
        white_pawn6 = new Pawn(true, new Coordinate(5, 2));
        white_pawn7 = new Pawn(true, new Coordinate(7, 2));
        white_pawn8 = new Pawn(true, new Coordinate(8, 2));

        black_pawn1 = new Pawn(false, new Coordinate(1, 7));
        black_pawn2 = new Pawn(false, new Coordinate(2, 7));
        black_pawn3 = new Pawn(false, new Coordinate(3, 7));
        black_pawn4 = new Pawn(false, new Coordinate(4, 7));
        black_pawn5 = new Pawn(false, new Coordinate(5, 7));
        black_pawn6 = new Pawn(false, new Coordinate(5, 7));
        black_pawn7 = new Pawn(false, new Coordinate(7, 7));
        black_pawn8 = new Pawn(false, new Coordinate(8, 7));

        white_rook1 = new Rook(true, new Coordinate(1, 1));
        white_rook2 = new Rook(true, new Coordinate(8, 1));
        black_rook1 = new Rook(false, new Coordinate(8, 8));
        black_rook2 = new Rook(false, new Coordinate(1, 8));

        white_bishop1 = new Bishop(true, new Coordinate(3, 1));
        white_bishop2 = new Bishop(true, new Coordinate(6, 1));
        black_bishop1 = new Bishop(false, new Coordinate(3, 8));
        black_bishop2 = new Bishop(false, new Coordinate(6, 8));

        white_knight1 = new Knight(true, new Coordinate(2, 1));
        white_knight2 = new Knight(true, new Coordinate(7, 1));
        black_knight1 = new Knight(false, new Coordinate(2, 8));
        black_knight2 = new Knight(false, new Coordinate(7, 8));

        white_queen = new Queen(true, new Coordinate(4, 1));
        black_queen = new Queen(false, new Coordinate(4, 8));

        white_king = new King(true, new Coordinate(5, 1));
        black_king = new King(false, new Coordinate(5, 8));

        figure_and_place_black.put("black_pawn1", "1 7");
        figure_and_place_black.put("black_pawn2", "2 7");
        figure_and_place_black.put("black_pawn3", "3 7");
        figure_and_place_black.put("black_pawn4", "4 7");
        figure_and_place_black.put("black_pawn5", "5 7");
        figure_and_place_black.put("black_pawn6", "6 7");
        figure_and_place_black.put("black_pawn7", "7 7");
        figure_and_place_black.put("black_pawn8", "8 7");

        figure_and_place_white.put("white_pawn1", "1 2");
        figure_and_place_white.put("white_pawn2", "2 2");
        figure_and_place_white.put("white_pawn3", "3 2");
        figure_and_place_white.put("white_pawn4", "4 2");
        figure_and_place_white.put("white_pawn5", "5 2");
        figure_and_place_white.put("white_pawn6", "6 2");
        figure_and_place_white.put("white_pawn7", "7 2");
        figure_and_place_white.put("white_pawn8", "8 2");

        figure_and_place_white.put("white_rook1", "1 1");
        figure_and_place_white.put("white_rook2", "8 1");
        figure_and_place_black.put("black_rook1", "8 8");
        figure_and_place_black.put("black_rook2", "1 8");

        figure_and_place_white.put("white_bishop1", "3 1");
        figure_and_place_white.put("white_bishop2", "6 1");
        figure_and_place_black.put("black_bishop1", "3 8");
        figure_and_place_black.put("black_bishop2", "6 8");

        figure_and_place_white.put("white_knight1", "2 1");
        figure_and_place_white.put("white_knight2", "7 1");
        figure_and_place_black.put("black_knight1", "2 8");
        figure_and_place_black.put("black_knight2", "7 8");

        figure_and_place_white.put("white_queen", "4 1");
        figure_and_place_black.put("black_queen", "4 8");

        figure_and_place_white.put("white_king", "5 1");
        figure_and_place_black.put("black_king", "5 8");

        Collection<String> white_figure = figure_and_place_white.values();
        Collection<String> black_figure = figure_and_place_black.values();

        while (is_play_continue) {
            count_ += 1;
            System.out.println("Ход номер: " + count_);
            System.out.println("Фигуры на доске:");
            System.out.println(figure_and_place_white);
            System.out.println(figure_and_place_black);
            if (count_ % 2 != 0) {
                obj_pawn = null;
                System.out.println("Ходят белые");
                if (is_shah_white) {
                    int begin_x = Integer.parseInt(figure_and_place_white.get("white_king").substring(0, 1));
                    int begin_y = Integer.parseInt(figure_and_place_white.get("white_king").substring(2));
                    List<String> empty_for_king = white_king.is_mat(begin_x, begin_y, black_figure, white_figure);
                    if (empty_for_king.size() == 0) {
                        System.out.println("Белому королю мат. Победили черные");
                        is_play_continue = false;
                    } else {
                        System.out.println("Белому королю шах. Он может сходить на следующие поля");
                        for (String t : empty_for_king) {
                            System.out.println(t);
                        }
                        System.out.println("На какое поле вы хотите сходить?");
                        x = sc.nextInt();
                        y = sc.nextInt();
                        boolean is_move = false;
                        for (String item : empty_for_king) {
                            if ((x + " " + y).equals(item)) {
                                is_move = true;
                                goTo1 = new Coordinate(x, y);
                                white_king.move(goTo1);
                                break;
                            }
                        }
                        if (!is_move) {
                            System.out.println("Вы не можете сходить на это поле");
                        }
                    }
                } else {
                    System.out.println("Какой фигурой вы хотите сходить? Введите Пешка/Ладья/Конь/Слон/Ферзь/Король");
                    figure = sc.next();
                    switch (figure) {
                        case "Пешка" -> {
                            System.out.println("Напишите номер пешки, которой хотели бы сходить");
                            String num = sc.next();
                            System.out.println("Начальные координаты пешки:");
                            System.out.println(figure_and_place_white.get("white_pawn" + num));
                            System.out.println("Введите конечные координаты пешки:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            switch (num) {
                                case "1" -> obj_pawn = white_pawn1;
                                case "2" -> obj_pawn = white_pawn2;
                                case "3" -> obj_pawn = white_pawn3;
                                case "4" -> obj_pawn = white_pawn4;
                                case "5" -> obj_pawn = white_pawn5;
                                case "6" -> obj_pawn = white_pawn6;
                                case "7" -> obj_pawn = white_pawn7;
                                case "8" -> obj_pawn = white_pawn8;
                                default -> System.err.println("Введено неверное значение");
                            }
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_white.get("white_pawn" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_white.get("white_pawn" + num).substring(2));
                            assert obj_pawn != null;
                            Map<String, String> res_of_kill = obj_pawn.is_can_kill(x, y, begin_x, begin_y, figure_and_place_black);
                            if (obj_pawn.canMove(goTo1)) {
                                int min_coordinate = Integer.parseInt(figure_and_place_white.get("white_pawn" + num).substring(2));
                                boolean is_move;
                                figure_and_place_white.remove("white_pawn" + num);
                                is_move = obj_pawn.move(y, min_coordinate, x, white_figure)
                                        && obj_pawn.move(y, min_coordinate, x, black_figure);
                                figure_and_place_white.put("white_pawn" + num, x + " " + y);
                                if (is_move) obj_pawn.move(goTo1);
                                else System.out.println("Ход невозможен");
                                is_shah_black = obj_pawn.is_shah(figure_and_place_black);
                                if(is_shah_black) mat_figure = "white_pawn" + num;
                                System.out.println(obj_pawn);
                            } else{
                                if(res_of_kill == null) System.out.println("Ход невозможен");
                                else {
                                    figure_and_place_black = res_of_kill;
                                    obj_pawn.move(goTo1);
                                }
                            }
                            System.out.println(obj_pawn);
                        }
                        case "Ладья" -> {
                            obj_rook = null;
                            System.out.println("Напишите номер ладьи, которой хотели бы сходить");
                            String num = sc.next();
                            switch (num) {
                                case "1" -> obj_rook = white_rook1;
                                case "2" -> obj_rook = white_rook2;
                                default -> System.err.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты ладьи:");
                            System.out.println(obj_rook);
                            System.out.println("Введите конечные координаты ладьи:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_white.get("white_rook" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_white.get("white_rook" + num).substring(2));
                            figure_and_place_white.remove("white_rook" + num);
                            boolean is_x_equal_begin_x;
                            boolean is_move;
                            assert obj_rook != null;
                            if (obj_rook.canMove(goTo1)) {
                                is_x_equal_begin_x = x == begin_x;
                                is_move = obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x, y, white_figure)
                                        && ((obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x-1, y-1, black_figure)
                                        && obj_rook.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_black) != null)
                                || (obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x, y, black_figure)
                                        && obj_rook.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_black) == null));
                                figure_and_place_white.put("white_rook" + num, x + " " + y);
                                if (is_move) obj_rook.move(goTo1);
                            } else System.out.println("Ход невозможен");
                            is_shah_black = obj_rook.is_shah(figure_and_place_black, black_figure, white_figure);
                            if(is_shah_black) mat_figure = "white_rook" + num;
                            System.out.println(obj_rook);
                        }
                        case "Конь" -> {
                            boolean is_move;
                            obj_knight = null;
                            System.out.println("Напишите номер коня, которым хотели бы сходить");
                            String num = sc.next();
                            switch (num) {
                                case "1" -> obj_knight = white_knight1;
                                case "2" -> obj_knight = white_knight2;
                                default -> System.err.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты коня:");
                            System.out.println(obj_knight);
                            System.out.println("Введите конечные координаты коня:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            assert obj_knight != null;
                            if (obj_knight.canMove(goTo1)) {
                                int begin_x = Integer.parseInt(figure_and_place_white.get("white_knight" + num).substring(0, 1));
                                int begin_y = Integer.parseInt(figure_and_place_white.get("white_knight" + num).substring(2));
                                Map<String, String> res_of_kill = obj_knight.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_black);
                                figure_and_place_white.remove("white_knight" + num);
                                is_move = is_empty_(x, y, white_figure)
                                        && (is_empty_(x, y, black_figure)
                                        || (res_of_kill != null));
                                if(res_of_kill != null) figure_and_place_black = res_of_kill;
                                figure_and_place_white.put("white_knight" + num, begin_x + " " + begin_y);
                                if (is_move) {
                                    obj_knight.move(goTo1);
                                    System.out.println(obj_knight);
                                } else System.out.println("Ход невозможен");
                            } else System.out.println("Ход невозможен");
                            is_shah_black = obj_knight.is_shah(figure_and_place_black, black_figure, white_figure);
                            if(is_shah_black) mat_figure = "white_knight" + num;
                            System.out.println(obj_knight);
                        }
                        case "Слон" -> {
                            obj_bishop = null;
                            System.out.println("Напишите номер коня, которым хотели бы сходить");
                            String num = sc.next();
                            switch (num) {
                                case "1" -> obj_bishop = white_bishop1;
                                case "2" -> obj_bishop = white_bishop2;
                                default -> System.err.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты слона:");
                            System.out.println(obj_bishop);
                            System.out.println("Введите конечные координаты слона:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_white.get("white_bishop" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_white.get("white_bishop" + num).substring(2));
                            figure_and_place_white.remove("white_bishop" + num);
                            max_x = Math.max(begin_x, x-1);
                            min_x = Math.min(begin_x, x-1);
                            max_y = Math.max(y-1, begin_y);
                            assert obj_bishop != null;
                            Map<String, String> res_of_kill = obj_bishop.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_black);
                            if (obj_bishop.canMove(goTo1)) {
                                boolean is_move = true;
                                if(res_of_kill != null || is_empty_(x, y, black_figure)) {
                                    if (res_of_kill != null) figure_and_place_black = res_of_kill;
                                    while (max_x != min_x) {
                                        is_move = (is_empty_(max_x, max_y, white_figure))
                                                & (is_empty_(max_x, max_y, black_figure));
                                        if (!is_move) break;
                                        max_x -= 1;
                                        max_y -= 1;
                                    }
                                    figure_and_place_white.put("white_bishop" + num, x + " " + y);
                                    if (is_move) obj_bishop.move(goTo1);
                                } else System.out.println("Ход невозможен");
                            } else System.out.println("Ход невозможен");
                            is_shah_black = obj_bishop.is_shah(figure_and_place_black, black_figure, white_figure);
                            if(is_shah_black) mat_figure = "white_bishop" + num;
                            System.out.println(obj_bishop);
                        }
                        case "Ферзь" -> {
                            System.out.println("Начальные координаты ферзя:");
                            System.out.println(white_queen);
                            System.out.println("Введите конечные координаты ферзя:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_white.get("white_queen").substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_white.get("white_queen").substring(2));
                            figure_and_place_white.remove("white_queen");
                            boolean is_move = true;
                            if (white_queen.canMove(goTo1)) {
                                if (x == begin_x || y == begin_y) {
                                    white_queen.move(x, y, black_figure, white_figure, begin_x, begin_y);
                                } else {
                                    max_x = Math.max(begin_x, x-1);
                                    min_x = Math.min(begin_x, x-1);
                                    max_y = Math.max(y-1, begin_y);
                                    Map<String, String> res_of_kill = white_queen.is_can_kill(x, y, figure_and_place_black);
                                    if(is_empty_(x, y, black_figure) || res_of_kill != null){
                                        figure_and_place_black = res_of_kill;
                                        while (max_x != min_x) {
                                            is_move = is_empty_(max_x, max_y, white_figure) && (is_empty_(max_x, max_y, black_figure));
                                            if(!is_move) break;
                                            max_x -= 1;
                                            max_y -= 1;
                                        }
                                    }
                                }
                                figure_and_place_white.put("white_queen", x + " " + y);
                            } else System.out.println("Ход невозможен");
                            if (is_move) white_queen.move(goTo1);
                            is_shah_black = white_queen.is_shah(figure_and_place_black, black_figure, white_figure);
                            if(is_shah_black) mat_figure = "white_queen";
                            System.out.println(white_queen);
                        }

                        case "Король" -> {
                            System.out.println("Начальные координаты короля:");
                            System.out.println(white_king);
                            System.out.println("Введите конечные координаты короля:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            figure_and_place_white.remove("white_king");
                            goTo1 = new Coordinate(x, y);
                            boolean is_move = true;
                            if (white_king.canMove(goTo1))
                                is_move = (is_empty_(x, y, white_figure)) && (is_empty_(x, y, black_figure));
                            else System.out.println("Ход невозможен");
                            figure_and_place_white.put("white_king", x + " " + y);
                            if (is_move) white_king.move(goTo1);
                            else System.out.println("Ход невозможен");
                            System.out.println(white_king);
                        }
                        default -> System.err.println("Введено неверное значение");
                    }
                }
            } else {
                System.out.println("Ходят черные");
                if (is_shah_black) {
                    int begin_x = Integer.parseInt(figure_and_place_black.get("black_king").substring(0, 1));
                    int begin_y = Integer.parseInt(figure_and_place_black.get("black_king").substring(2));
                    List<String> empty_for_king = black_king.is_mat(begin_x, begin_y, black_figure, white_figure);
                    if (empty_for_king.size() == 0) {
                        System.out.println("Черному королю мат. Победили белые");
                        is_play_continue = false;
                    } else {
                        System.out.println("Черному королю шах. Он может сходить на следующие поля");
                        for (String t : empty_for_king) System.out.println(t);
                        System.out.println("На какое поле вы хотите сходить?");
                        x = sc.nextInt();
                        y = sc.nextInt();
                        boolean is_move = false;
                        for (String item : empty_for_king) {
                            if ((x + " " + y).equals(item)) {
                                is_move = true;
                                goTo1 = new Coordinate(x, y);
                                white_king.move(goTo1);
                                break;
                            }
                        }
                        if (!is_move) System.out.println("Вы не можете сходить на это поле");
                    }
                } else {
                    System.out.println("Какой фигурой вы хотите сходить? Введите Пешка/Ладья/Конь/Слон/Ферзь/Король");
                    figure = sc.next();
                    switch (figure) {
                        case "Пешка" -> {
                            obj_pawn = null;
                            System.out.println("Напишите номер пешки, которой хотели бы сходить");
                            String num = sc.next();
                            System.out.println("Начальные координаты пешки:");
                            System.out.println(figure_and_place_black.get("black_pawn" + num));
                            System.out.println("Введите конечные координаты пешки:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            switch (num) {
                                case "1" -> obj_pawn = black_pawn1;
                                case "2" -> obj_pawn = black_pawn2;
                                case "3" -> obj_pawn = black_pawn3;
                                case "4" -> obj_pawn = black_pawn4;
                                case "5" -> obj_pawn = black_pawn5;
                                case "6" -> obj_pawn = black_pawn6;
                                case "7" -> obj_pawn = black_pawn7;
                                case "8" -> obj_pawn = black_pawn8;
                                default -> System.err.println("Введено неверное значение");
                            }
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_black.get("black_pawn" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_black.get("black_pawn" + num).substring(2));
                            assert obj_pawn != null;
                            Map<String, String> res_of_kill = obj_pawn.is_can_kill(x, y, begin_x, begin_y, figure_and_place_white);
                            if (obj_pawn.canMove(goTo1)) {
                                int max_coordinate = y;
                                int min_coordinate = Integer.parseInt(figure_and_place_black.get("black_pawn" + num).substring(2));
                                boolean is_move = true;
                                figure_and_place_black.remove("black_pawn" + num);
                                while (max_coordinate > min_coordinate) {
                                    is_move = is_empty_(x, max_coordinate, black_figure);
                                    max_coordinate -= 1;
                                }
                                figure_and_place_black.put("black_pawn" + num, x + " " + y);
                                if (is_move) obj_pawn.move(goTo1);
                                is_shah_white = obj_pawn.is_shah(figure_and_place_white);
                                if(is_shah_white) mat_figure = "black_pawn" + num;
                                System.out.println(obj_pawn);
                            } else{
                                if(res_of_kill == null) System.out.println("Ход невозможен");
                                else {
                                    figure_and_place_black = res_of_kill;
                                    obj_pawn.move(goTo1);
                                }
                            }
                        }
                        case "Ладья" -> {
                            obj_rook = null;
                            System.out.println("Напишите номер ладьи, которой хотели бы сходить");
                            String num = sc.next();
                            switch (num) {
                                case "1" -> obj_rook = black_rook1;
                                case "2" -> obj_rook = black_rook2;
                                default -> System.out.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты ладьи:");
                            System.out.println(obj_rook);
                            System.out.println("Введите конечные координаты ладьи:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_black.get("black_rook" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_black.get("black_rook" + num).substring(2));
                            figure_and_place_black.remove("black_rook" + num);
                            boolean is_move;
                            boolean is_x_equal_begin_x;
                            assert obj_rook != null;
                            Map<String, String> res_of_kill =
                                    obj_rook.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_white);
                            if (obj_rook.canMove(goTo1) || res_of_kill != null) {
                                is_x_equal_begin_x = x == begin_x;
                                is_move = obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x, y, black_figure)
                                        && ((obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x-1, y-1, white_figure)
                                        && res_of_kill != null)
                                        || (obj_rook.move(is_x_equal_begin_x, begin_x, begin_y, x, y, black_figure)
                                        && res_of_kill == null));
                                figure_and_place_white.put("black_rook" + num, x + " " + y);
                                if (is_move) obj_rook.move(goTo1);
                            } else System.out.println("Ход невозможен");
                            is_shah_white = obj_rook.is_shah(figure_and_place_black, black_figure, white_figure);
                            if(is_shah_white) mat_figure = "black_rook" + num;
                            System.out.println(obj_rook);
                        }
                        case "Конь" -> {
                            obj_knight = null;
                            System.out.println("Напишите номер коня, которым хотели бы сходить");
                            String num = sc.next();
                            boolean is_move;
                            switch (num) {
                                case "1" -> obj_knight = black_knight1;
                                case "2" -> obj_knight = black_knight2;
                                default -> System.err.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты коня:");
                            System.out.println(obj_knight);
                            System.out.println("Введите конечные координаты коня:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            assert obj_knight != null;
                            if (obj_knight.canMove(goTo1)) {
                                int begin_x = Integer.parseInt(figure_and_place_black.get("black_knight" + num).substring(0, 1));
                                int begin_y = Integer.parseInt(figure_and_place_black.get("black_knight" + num).substring(2));
                                Map<String, String> res_of_kill = obj_knight.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_black);
                                figure_and_place_white.remove("white_knight" + num);
                                is_move = is_empty_(x, y, white_figure)
                                        && (is_empty_(x, y, black_figure)
                                        || (res_of_kill != null));
                                if(res_of_kill != null) figure_and_place_black = res_of_kill;
                                figure_and_place_black.put("black_knight" + num, begin_x + " " + begin_y);
                                if (is_move) obj_knight.move(goTo1);
                                else System.out.println("Ход невозможен");
                            } else System.out.println("Ход невозможен");
                            is_shah_white = obj_knight.is_shah(figure_and_place_white, black_figure, white_figure);
                            if(is_shah_white) mat_figure = "black_knight" + num;
                            System.out.println(obj_knight);
                        }
                        case "Слон" -> {
                            obj_bishop = null;
                            System.out.println("Напишите номер коня, которым хотели бы сходить");
                            String num = sc.next();
                            switch (num) {
                                case "1" -> obj_bishop = black_bishop1;
                                case "2" -> obj_bishop = black_bishop2;
                                default -> System.out.println("Введено неверное значение");
                            }
                            System.out.println("Начальные координаты слона:");
                            System.out.println(obj_bishop);
                            System.out.println("Введите конечные координаты слона:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_black.get("black_bishop" + num).substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_black.get("black_bishop" + num).substring(2));
                            figure_and_place_black.remove("black_bishop" + num);
                            max_x = Math.max(begin_x, x-1);
                            min_x = Math.min(begin_x, x-1);
                            max_y = Math.max(y-1, begin_y);
                            assert obj_bishop != null;
                            Map<String, String> res_of_kill = obj_bishop.is_can_kill(String.valueOf(x), String.valueOf(y), figure_and_place_white);
                            if (obj_bishop.canMove(goTo1) || res_of_kill != null) {
                                boolean is_move = true;
                                if(res_of_kill != null || is_empty_(x, y, white_figure)) {
                                    while (max_x != min_x) {
                                        is_move = (is_empty_(max_x, max_y, black_figure))
                                                & (is_empty_(max_x, max_y, white_figure));
                                        if (!is_move) break;
                                        max_x -= 1;
                                        max_y -= 1;
                                    }
                                    figure_and_place_black.put("black_bishop" + num, x + " " + y);
                                    if (is_move){
                                        if (res_of_kill != null) figure_and_place_white = res_of_kill;
                                        else if(is_empty_(x, y, white_figure) && is_empty_(x, y, black_figure))
                                            obj_bishop.move(goTo1);
                                        else System.out.println("Ход невозможен");
                                    }
                                } else System.out.println("Ход невозможен");
                            } else System.out.println("Ход невозможен");
                            is_shah_white = obj_bishop.is_shah(figure_and_place_white, black_figure, white_figure);
                            if(is_shah_white) mat_figure = "black_bishop" + num;
                            System.out.println(obj_bishop);
                        }
                        case "Ферзь" -> {
                            System.out.println("Начальные координаты ферзя:");
                            System.out.println(black_queen);
                            System.out.println("Введите конечные координаты ферзя:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            int begin_x = Integer.parseInt(figure_and_place_black.get("black_queen").substring(0, 1));
                            int begin_y = Integer.parseInt(figure_and_place_black.get("black_queen").substring(2));
                            figure_and_place_black.remove("black_queen");
                            boolean is_move = true;
                            Map<String, String> res_of_kill = black_queen.is_can_kill(x, y, figure_and_place_white);
                            if (black_queen.canMove(goTo1) || res_of_kill != null) {
                                if (x == begin_x || y == begin_y) {
                                    black_queen.move(x, y, black_figure, white_figure, begin_x, begin_y);
                                } else {
                                    max_x = Math.max(begin_x, x-1);
                                    min_x = Math.min(begin_x, x-1);
                                    max_y = Math.max(y-1, begin_y);
                                    if(is_empty_(x, y, white_figure) || res_of_kill != null){
                                        if(res_of_kill != null) figure_and_place_white = res_of_kill;
                                        while (max_x != min_x) {
                                            is_move = is_empty_(max_x, max_y, black_figure) && (is_empty_(max_x, max_y, white_figure));
                                            if(!is_move) break;
                                            max_x -= 1;
                                            max_y -= 1;
                                        }
                                    }
                                }
                                figure_and_place_black.put("black_queen", x + " " + y);
                            } else System.out.println("Ход невозможен");
                            if (is_move) black_queen.move(goTo1);
                            is_shah_white = black_queen.is_shah(figure_and_place_white, black_figure, white_figure);
                            if(is_shah_white) mat_figure = "white_queen";
                            System.out.println(black_queen);
                        }
                        case "Король" -> {
                            System.out.println("Начальные координаты короля:");
                            System.out.println(black_king);
                            System.out.println("Введите конечные координаты короля:");
                            x = sc.nextInt();
                            y = sc.nextInt();
                            goTo1 = new Coordinate(x, y);
                            figure_and_place_black.remove("black_king");
                            boolean is_move = true;
                            if (black_king.canMove(goTo1))
                                is_move = (is_empty_(x, y, white_figure)) && (is_empty_(x, y, black_figure));
                            else System.out.println("Ход невозможен");
                            figure_and_place_black.put("black_king", x + " " + y);
                            if (is_move) black_king.move(goTo1);
                            else System.out.println("Ход невозможен");
                            System.out.println(black_king);
                        }
                        default -> System.err.println("Введено неверное значение");
                    }
                }
            }
        }
    }
}