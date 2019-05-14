package net.focusdelivery.focusdeliverymotoboy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        List<String> linguagens = new ArrayList<>(Arrays.asList("Avulso",
                "cg_central_acacio_figueiredo",
                "cg_central_acacio_figueiredo_i",
                "cg_central_acacio_figueiredo_ii",
                "cg_central_alameda",
                "cg_central_alameda_i",
                "cg_central_alameda_ii",
                "cg_central_alto_branco",
                "cg_central_alto_branco_i",
                "cg_central_alto_branco_ii",
                "cg_central_araxa",
                "cg_central_araxa_i",
                "cg_central_araxa_ii",
                "cg_central_bairro_das_cidades",
                "cg_central_bairro_das_cidades_i",
                "cg_central_bairro_das_nacoes",
                "cg_central_bairro_das_nacoes_i",
                "cg_central_bairro_das_nacoes_ii",
                "cg_central_bairro_universitario",
                "cg_central_bairro_universitario_i",
                "cg_central_bairro_universitario_ii",
                "cg_central_bela_vista",
                "cg_central_bela_vista_i",
                "cg_central_bela_vista_ii",
                "cg_central_bodocongo",
                "cg_central_bodocongo_i",
                "cg_central_bodocongo_ii",
                "cg_central_bodocongo_iii",
                "cg_central_bodocongo_iv",
                "cg_central_caatingueira",
                "cg_central_caatingueira_i",
                "cg_central_catole",
                "cg_central_catole_i",
                "cg_central_catole_ii",
                "cg_central_catole_iii",
                "cg_central_centenario",
                "cg_central_centenario_i",
                "cg_central_centenario_ii",
                "cg_central_centro",
                "cg_central_centro_i",
                "cg_central_centro_ii",
                "cg_central_cinza",
                "cg_central_cinza_i",
                "cg_central_cinza_ii",
                "cg_central_conceicao",
                "cg_central_conceicao_i",
                "cg_central_cruzeiro",
                "cg_central_cruzeiro_i",
                "cg_central_cuites",
                "cg_central_dinamerica",
                "cg_central_dinamerica_i",
                "cg_central_distrito_industrial",
                "cg_central_distrito_industrial_i",
                "cg_central_estacao_velha",
                "cg_central_gloria",
                "cg_central_itarare",
                "cg_central_jardim_continental",
                "cg_central_jardim_paulistano",
                "cg_central_jardim_tavares",
                "cg_central_jardim_verdejante",
                "cg_central_jeremias",
                "cg_central_joao_paulo_ii",
                "cg_central_jose_pinheiro",
                "cg_central_jose_pinheiro_i",
                "cg_central_jose_pinheiro_ii",
                "cg_central_lauritzen",
                "cg_central_liberdade",
                "cg_central_ligeiro",
                "cg_central_louzeiro",
                "cg_central_major_veneziano",
                "cg_central_malvinas",
                "cg_central_malvinas_i",
                "cg_central_malvinas_ii",
                "cg_central_malvinas_iii",
                "cg_central_mirante",
                "cg_central_monte_castelo",
                "cg_central_monte_santo",
                "cg_central_nova_brasilia",
                "cg_central_novo_bodocongo",
                "cg_central_novo_cruzeiro",
                "cg_central_novo_horizonte",
                "cg_central_palmeira",
                "cg_central_palmeira_imperial",
                "cg_central_pedregal",
                "cg_central_portal_sudoeste",
                "cg_central_prata",
                "cg_central_presidente_medici",
                "cg_central_quarenta",
                "cg_central_ramadinha",
                "cg_central_rocha_cavalcante",
                "cg_central_rosa_cruz",
                "cg_central_sandra_cavalcante",
                "cg_central_santa_cruz",
                "cg_central_santa_rosa",
                "cg_central_santo_antonio",
                "cg_central_sao_jose",
                "cg_central_serrotao",
                "cg_central_severino_cabral",
                "cg_central_tambor",
                "cg_central_tres_irmas",
                "cg_central_velame",
                "cg_central_vila_cabral_de_santa_rosa",
                "cg_central_vila_cabral_de_santa_terezinha"
                ));

        Button btn_entrar = (Button) findViewById(R.id.btn_entrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarWeb();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, linguagens);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                SharedPreferences prefs = getSharedPreferences("BD", Context.MODE_PRIVATE);
                if (item == "Avulso"){
                    item = "motoboys";
                }
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("topicSelected", item);
                editor.apply();
                Log.d("TOPIC: ", item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void mostrarWeb() {
        Intent intent = new Intent(SelectActivity.this,
                MainActivity.class);
        startActivity(intent);
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Carregando");
        progress.setMessage("...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        finish();
    }

}
