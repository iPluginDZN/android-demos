package com.pplugin.tictoetoygame;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int winner = 0;
    int startGame = 0;
    Button btnPlayStatus;
    TableLayout table;
    TextView txtShowresult;
    boolean player;
    int[][] state = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayStatus = (Button) findViewById(R.id.btPlayAgain);
        txtShowresult = (TextView) findViewById(R.id.txtShowresult);
        table = (TableLayout) findViewById(R.id.table);
        btnPlayStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startGame == 1) {
                    PlayAgain();
                    startGame = 0;
                    btnPlayStatus.setText("Bắt đầu");
                } else if (startGame == 0) {
                    btnPlayStatus.setText("Chơi lại");
                    startGame = 1;
                }
            }
        });
    }

    void PlayAgain() {
        for (int[] i : state) {
            Arrays.fill(i,0);
        }

        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                View view = row.getChildAt(j);
                if (view instanceof Button) {
                    Button button = (Button) view;
                    button.setText("");
                    button.setBackgroundColor(Color.rgb(188, 185, 185));
                }
            }
        }
        txtShowresult.setVisibility(View.INVISIBLE);
        winner = 0;
    }

    public void btClick(View view) {
        Button btSelected = (Button) view;
        TableRow button_row = (TableRow) btSelected.getParent();

        Log.d("", "Hang : " + String.valueOf(table.indexOfChild(button_row)));
        Log.d("", "Cot : " + String.valueOf(button_row.indexOfChild(btSelected)));
        if (state[table.indexOfChild(button_row)][button_row.indexOfChild(btSelected)] == 0 && winner == 0 && startGame == 1) {
            Log.d("", "step 1");
            if (!player) {
                btSelected.setBackgroundColor(Color.rgb(255, 102, 153));
                state[table.indexOfChild(button_row)][button_row.indexOfChild(btSelected)] = 1;
                btSelected.setText("X");
            } else {
                btSelected.setBackgroundColor(Color.rgb(102, 0, 255));
                btSelected.setText("O");
                state[table.indexOfChild(button_row)][button_row.indexOfChild(btSelected)] = 2;
            }
            Log.d("", "step 2");
            check_winner();
            if (winner == 0) player = !player;
            if (winner == 1) {
                txtShowresult.setVisibility(View.VISIBLE);
                if (!player) {
                    txtShowresult.setText("X thắng !");
                } else {
                    txtShowresult.setText("O thắng !");
                }
            }
            if (winner == 2) {
                txtShowresult.setVisibility(View.VISIBLE);
                txtShowresult.setText("Hòa !");
            }
        }
    }

    void check_winner() {
        winner = 1;
        boolean tie = true;
        while (true) {
            boolean stop_while = false;
            for (int i = 0; i < 3; i++) {
                if (state[i][0] != 0 && state[i][1] != 0 && state[i][2] != 0 && state[i][0] == state[i][1] && state[i][1] == state[i][2]) {
                    stop_while = true;
                    break;
                }
            }
            if (stop_while) break;

            for (int i = 0; i < 3; i++) {
                if (state[0][i] != 0 && state[1][i] != 0 && state[2][i] != 0 && state[0][i] == state[1][i] && state[1][i] == state[2][i]) {
                    stop_while = true;
                    break;
                }
            }
            if (stop_while) break;

            if (state[0][0] != 0 && state[1][1] != 0 && state[2][2] != 0 && state[0][0] == state[1][1] && state[1][1] == state[2][2])
                break;
            if (state[0][2] != 0 && state[1][1] != 0 && state[2][0] != 0 && state[0][2] == state[1][1] && state[1][1] == state[2][0])
                break;

            winner = 0;
            break;
        }

        for (int[] i : state) {
            for (int j : i) {
                if (j == 0) {
                    tie = false;
                    break;
                }
            }
        }
        if (tie && winner == 0) {
            winner = 2;
        }
    }
}

