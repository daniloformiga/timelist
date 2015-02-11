/***
	Copyright (c) 2008-2010 CommonsWare, LLC
	
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package br.com.lercode;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.lercode.login.Login;

public class Lercode extends Activity {
	
	HashMap<String, Produto> produtos = new HashMap<String, Produto>();  	
	
	TextView format=null;
	TextView contents=null;
	TextView preco=null;
	TextView nome=null;
	Button btnSair=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		preencherListaProduto();
		
		format=(TextView)findViewById(R.id.format);
		contents=(TextView)findViewById(R.id.contents);
		preco=(TextView)findViewById(R.id.preco);
		nome=(TextView)findViewById(R.id.nome);
		btnSair=(Button)findViewById(R.id.btnSair);
		
		btnSair.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Lercode.this, Login.class);
        		startActivity(intent);
				
			}
			
		});
	}
	
	public void doScan(View v) {
		(new IntentIntegrator(this)).initiateScan();
	}
	
	public void onActivityResult(int request, int result, Intent i) {
		
		IntentResult scan=IntentIntegrator.parseActivityResult(request,result,i);
		
		if (scan!=null) {
			
			
			if(produtos.containsKey(scan.getContents())){
				
				Produto p = produtos.get(scan.getContents());
				
				format.setText("Codigo de Barra: " + p.getCodigoBarra());
				contents.setText("Quantidade: " + p.getQuantidade());
				preco.setText("Preço: " + p.getPreco());
				nome.setText("Nome: " + p.getNome());
				
			}else{
				format.setText("Produto não encontrado");
				contents.setText("");
				preco.setText("");
				nome.setText("");
			}
			
			
			
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle state) {
		state.putString("format", format.getText().toString());
		state.putString("contents", contents.getText().toString());
		state.putString("preco", preco.getText().toString());
		state.putString("nome", nome.getText().toString());
	}
	
	@Override
	public void onRestoreInstanceState(Bundle state) {
		format.setText(state.getString("format"));
		contents.setText(state.getString("contents"));
		preco.setText(state.getString("preco"));
		nome.setText(state.getString("nome"));
	}
	
	public void preencherListaProduto() {
		
		Produto p = new Produto();
		p.setCodigoBarra("00001.00000");
		p.setNome("Tenis Adidas");
		p.setQuantidade(15);
		p.setPreco(160.5);
		
		Produto p2 = new Produto();
		p2.setCodigoBarra("00002.00000");
		p2.setNome("Havaiana Preta");
		p2.setQuantidade(6);
		p2.setPreco(15);
		
		Produto p3 = new Produto();
		p3.setCodigoBarra("Kamaleon");
		p3.setNome("Kamaleon TI");
		p3.setQuantidade(1);
		p3.setPreco(50000);
		
		produtos.put(p.getCodigoBarra(), p);
		produtos.put(p2.getCodigoBarra(), p2);
		produtos.put(p3.getCodigoBarra(), p3);
		
		
	}
}
