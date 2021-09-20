package com.coderefer.learnconcepts.lld.designChessGame;


import java.util.List;

public class Chess {
    ChessBoard chessBoard;
    Player[] players;
    Player currentPlayer;
    List<Move> movesList;
    GameStatus gameStatus;
    public boolean playerMove(CellPosition fromPos, CellPosition  toPos, Piece piece){
        return false;
    }
    public boolean endGame(){
        return false;
    }
//    need not be called from outside. Our chess class will take care of this. forfeited
    private void changeTurn() {

    }
}

class ChessBoard {
    List<List<Cell>> board;
    public void resetBoard() {

    }
    public void updateBoard(Move move) {

    }
}
class Move {
    Player current;
    Piece piece;
    Piece killedPiece;
    CellPosition startPos;
    CellPosition endPos;
}

abstract class Piece {
    Color color;
    public abstract boolean move(CellPosition from, CellPosition to);
    public abstract List<CellPosition> possibleMoves();
    public abstract boolean validate(CellPosition from, CellPosition to);
}

class King extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Queen extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Bishop extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Knight extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Rook extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Pawn extends Piece {

    @Override
    public boolean move(CellPosition from, CellPosition to) {
        return false;
    }

    @Override
    public List<CellPosition> possibleMoves() {
        return null;
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return false;
    }
}

class Cell {
    Color cellColor;
    CellPosition position;
    Piece currentPiece;
}
class CellPosition {
    char ch;
    int i;
}

enum GameStatus {
    ACTIVE, PAUSED, FORFEITED, BLACK_WIN, WHITE_WIN
}

class Player {
    Account account;
    Color color;
}

enum Color {
    BLACK, WHITE
}

class Account {
    String userName;
    String password;

    String name;
    String email;
    String phNo;
}

class Time {
    int mins;
    int secs;
}
