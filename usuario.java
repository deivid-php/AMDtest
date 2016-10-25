package com.equipe2.amd;
import java.sql.ResultSet;
import java.util.ArrayList;
public class usuario extends _Default {
    private String id;
    private String senha;
    public usuario(){
        super();
        this.id = "";
        this.senha = "";
    }
    public ArrayList<usuario> getLista(){
        DB db = new DB();
        ArrayList<usuario> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario");
            if (resultSet != null){
                while (resultSet.next()){
                    usuario obj = new usuario();
                    obj.setId(resultSet.getString("id"));
                    obj.setSenha(resultSet.getString("senha"));
                    lista.add(obj);
                    obj = null;
                }
            }
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }
    public void salvar(){
        String comando = "";
        if (this.getId() == "-1"){
            comando = String.format("INSERT INTO usuario (id,  senha) VALUES ('%s','%s');",
                    this.getId(),this.getSenha());
        }else{
            comando = String.format("UPDATE usuario SET id = '%s', senha = '%s' WHERE id = %d;",
                    this.getId(),this.getSenha());
        }
        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }
    public void apagar(){
        String comando = String.format("DELETE FROM usuario WHERE id = %d;",this.getId());
        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

