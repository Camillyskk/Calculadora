package com.example.calculadora;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    public Button num_um, num_dois, num_tres, num_quatro, num_cinco, num_seis, num_sete, num_oito, num_nove, num_zero, ponto, igual, soma, subtracao, divisao, multiplicacao, deletar, limpar;
    public TextView expressao, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iniciar();

        num_um.setOnClickListener(this);
        num_dois.setOnClickListener(this);
        num_tres.setOnClickListener(this);
        num_quatro.setOnClickListener(this);
        num_cinco.setOnClickListener(this);
        num_seis.setOnClickListener(this);
        num_sete.setOnClickListener(this);
        num_oito.setOnClickListener(this);
        num_nove.setOnClickListener(this);
        num_zero.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressao.setText("");
                resultado.setText("");
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = expressao.getText().toString();
                if(!str.isEmpty()){
                    int pFinal = str.length()-1;
                    String novaExpressao = str.substring(0, pFinal);
                    expressao.setText(novaExpressao);
                }
                resultado.setText("");

            }
        });

        igual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression expression = new ExpressionBuilder(expressao.getText().toString()).build();
                double resultadoFinal = expression.evaluate();
                long longRes = (long) resultadoFinal;

                if(resultadoFinal == (double)longRes){
                    resultado.setText((CharSequence) String.valueOf(longRes));
                } else{
                    resultado.setText((CharSequence) String.valueOf(resultadoFinal));
                }
            }
        });
    }

    public void Add(String caracter, boolean limpar){
        if(resultado.getText().equals("")){
            expressao.setText(" ");
        }
        if(limpar){
            resultado.setText(" ");
            expressao.append(caracter);
        }
        else{
            expressao.append(resultado.getText());
            expressao.append(caracter);
            resultado.setText(" ");
        }
        
    }

    public void Iniciar(){
        num_um = findViewById(R.id.bt_1);
        num_dois = findViewById(R.id.bt_2);
        num_tres = findViewById(R.id.bt_3);
        num_quatro = findViewById(R.id.bt_4);
        num_cinco = findViewById(R.id.bt_5);
        num_seis = findViewById(R.id.bt_6);
        num_sete = findViewById(R.id.bt_7);
        num_oito = findViewById(R.id.bt_8);
        num_nove = findViewById(R.id.bt_9);
        num_zero = findViewById(R.id.bt_0);

        ponto = findViewById(R.id.bt_ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        divisao = findViewById(R.id.bt_divisao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        igual = findViewById(R.id.igual);
        deletar = findViewById(R.id.bt_deletar);
        limpar = findViewById(R.id.limpar);
        expressao = findViewById(R.id.tv_expressao);
        resultado = findViewById(R.id.tv_resultado);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_1:
                Add("1", true);
                break;
            case R.id.bt_2:
                Add("2", true);
                break;
            case R.id.bt_3:
                Add("3", true);
                break;
            case R.id.bt_4:
                Add("4", true);
                break;
            case R.id.bt_5:
                Add("5", true);
                break;
            case R.id.bt_6:
                Add("6", true);
                break;
            case R.id.bt_7:
                Add("7", true);
                break;
            case R.id.bt_8:
                Add("8", true);
                break;
            case R.id.bt_9:
                Add("9", true);
                break;
            case R.id.bt_0:
                Add("0", true);
                break;
            case R.id.bt_ponto:
                Add(".", true);
                break;
            case R.id.bt_soma:
                Add("+", false);
                break;
            case R.id.bt_subtracao:
                Add("-", false);
                break;
            case R.id.bt_divisao:
                Add("/", false);
                break;
            case R.id.bt_multiplicacao:
                Add("*", false);
                break;
        }
    }
}