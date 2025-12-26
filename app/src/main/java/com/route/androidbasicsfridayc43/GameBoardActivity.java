package com.route.androidbasicsfridayc43;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class GameBoardActivity extends AppCompatActivity {
    final static String O_SYMBOL = "O";
    final static String X_SYMBOL = "X";
    final static String FIRST_PLAYER = "firstPlayer";

    int counter = 0;
    String[] board = {"", "", "", "", "", "", "", "", ""};
    ConstraintLayout boardContainer;
    TextView playerTurnText;
    TextView timerTv;
    int seconds = 0;
    String firstPlayer = "";
    String secondPlayer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        firstPlayer = getIntent().getStringExtra(FIRST_PLAYER);
        secondPlayer = firstPlayer.equals(X_SYMBOL) ? O_SYMBOL : X_SYMBOL;
        initView();
        startTimer();
    }

    private void initView() {
        boardContainer = findViewById(R.id.boardContainer);
        playerTurnText = findViewById(R.id.playerTurnTv);
        timerTv = findViewById(R.id.timerTv);
    }

    private void startTimer() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                seconds++;
                int minutes = seconds / 60;
                int remainingSeconds = seconds - minutes * 60;
                String formattedMinutes = minutes < 10 ? "0" + minutes : minutes + "";
                String formattedSeconds = remainingSeconds < 10 ? "0" + remainingSeconds : remainingSeconds + "";
                String time = formattedMinutes + ":" + formattedSeconds;
                handler.postDelayed(this, 1000);
                timerTv.setText(time);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public void onPlayerClick(View v) {
        TextView clickedText = (TextView) v;
        if (!clickedText.getText().toString().isEmpty()) return;
        String symbol = counter % 2 == 0 ? firstPlayer : secondPlayer;
        clickedText.setText(symbol);
        int index = Integer.parseInt((String) clickedText.getTag());
        board[index] = symbol;
        Log.e("onPlayerClick", "symbol = " + symbol + ", symbol.equals(O_SYMBOL) = " + symbol.equals(O_SYMBOL) + " counter = " +counter);
        if (symbol.equals(O_SYMBOL)) {
            clickedText.setTextColor(ContextCompat.getColor(this, R.color.green));
        }
        String playerNumber = counter % 2 == 0 ? "1" : "2";
        if (checkWinner()) {
            Toast.makeText(this, "Player " + playerNumber + " Wins", Toast.LENGTH_LONG)
                    .show();
            resetBoard();
            return;
        }
        if (counter == 8) {
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG)
                    .show();
            resetBoard();
            return;
        }
        counter++;
        switchPlayerTurnText();
    }

    private void switchPlayerTurnText() {
        String playerNumber = counter % 2 == 0 ? "1's" : "2's";
        playerTurnText.setText("Player " + playerNumber + " Turn");
    }

    private void resetBoard() {
        board = new String[]{"", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < boardContainer.getChildCount(); i++) {
            View v = boardContainer.getChildAt(i);
            if (v instanceof TextView) {
                TextView button = (TextView) v;
                button.setText("");
                button.setTextColor(ContextCompat.getColor(this, R.color.red));
            }
        }
        counter = 0;
        seconds = 0;
    }

    public boolean checkWinner() {
        String symbol = counter % 2 == 0 ? firstPlayer : secondPlayer;
        /// Rows
        if (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol)) {
            return true;
        }
        if (board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol)) {
            return true;
        }
        if (board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        /// Columns
        if (board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol)) {
            return true;
        }
        if (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)) {
            return true;
        }
        if (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        /// Diagonals
        if (board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        if (board[2].equals(symbol) && board[4].equals(symbol) && board[6].equals(symbol)) {
            return true;
        }
        return false;
    }
}