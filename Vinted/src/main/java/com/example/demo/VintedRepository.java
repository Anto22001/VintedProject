package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VintedRepository {
    @Autowired
    JdbcTemplate db_vinted;

    //utente
    public boolean createUser(UtenteModel u){
        int rowAffected = db_vinted.update("insert into vinted.utente(id,nome,cognome,data_nascita,citta) values (?,?,?,?,?)",
                        u.getId(),u.getNome(),u.getCognome(),u.getData_nascita(),u.getCitta());
        return rowAffected>0;
    }

    public boolean removeUser(String id){
        int rowAffected = db_vinted.update("delete from vinted.utente where id=?",id);
        return rowAffected>0;
    }

    public boolean updateUser(UtenteModel u){
        int rowAffected = db_vinted.update("update vinted.utente set nome=?, cognome=?, data_nascita=?, citta=? where id=?",u.getNome(),u.getCognome(),u.getData_nascita(),u.getCitta(),u.getId());
        return rowAffected>0;
    }

    public List<UtenteModel> getUtenti(){
        return this.db_vinted.query("select * from vinted.utente ORDER BY id;",
            (rs, rowNum) ->
                new UtenteModel(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getDate("data_nascita").toLocalDate(),
                        rs.getString("citta")
                )
        );
    }

    //categoria
    public boolean createCategory(CategoriaModel c){
        int rowAffected = db_vinted.update("insert into vinted.categoria(id,nome) values (?,?)",
                c.getId(),c.getNome());
        return rowAffected>0;
    }

    public boolean removeCategory(String id){
        int rowAffected = db_vinted.update("delete from vinted.categoria where id=?",id);
        return rowAffected>0;
    }

    public boolean updateCategory(CategoriaModel c){
        int rowAffected = db_vinted.update("update vinted.categoria set nome=? where id=?",c.getNome(),c.getId());
        return rowAffected>0;
    }

    public List<CategoriaModel> getCategorie(){
        return this.db_vinted.query("select * from vinted.categoria ORDER BY id;",
                (rs, rowNum) ->
                        new CategoriaModel(
                                rs.getString("id"),
                                rs.getString("nome")
                        )
        );
    }

    //recensione
    public boolean createRecensione(RecensioneUtenteModel r){
        int rowAffected = db_vinted.update("insert into vinted.recensione(id,id_recensore,id_recensito,titolo,testo,valutazione,data_pubblicazione) " +
                        "values (?,?,?,?,?,?,?)",
                r.getId(),r.getId_recensore(),r.getId_recensito(),r.getTitolo(),r.getTesto(),r.getValutazione(),r.getData_pubblicazione());
        return rowAffected>0;
    }

    public boolean removeRecensione(String id){
        int rowAffected = db_vinted.update("delete from vinted.recensione where id=?",id);
        return rowAffected>0;
    }

    public boolean updateRecensione(RecensioneUtenteModel r){
        int rowAffected = db_vinted.update("update vinted.recensione set titolo=?,testo=?,valutazione=? where id=?",
                r.getTitolo(),r.getTesto(),r.getValutazione(),r.getId());
        return rowAffected>0;
    }

    public List<RecensioneUtenteModel> getRecensioni(){
        return this.db_vinted.query("select * from vinted.recensione ORDER BY valutazione,data_pubblicazione;",
                (rs, rowNum) ->
                        new RecensioneUtenteModel(
                                rs.getString("id"),
                                rs.getString("id_recensore"),
                                rs.getString("id_recensito"),
                                rs.getString("titolo"),
                                rs.getString("testo"),
                                rs.getInt("valutazione"),
                                rs.getDate("data_pubblicazione").toLocalDate()
                        )
        );
    }
    //acquisto
    public boolean createAcquisto(AcquistoModel a){
        int rowAffected = db_vinted.update("insert into vinted.acquisto(id,id_acquirente,id_articolo,data_acquisto,modalita_spedizione, data_spedizione) " +
                        "values (?,?,?,?,?,?)",
                a.getId(),a.getId_acquirente(),a.getId_articolo(), a.getData_acquisto(), a.getMode_spedizione(),a.getData_spedizione());
        return rowAffected>0;
    }

    public boolean removeAcquisto(String id){
        int rowAffected = db_vinted.update("delete from vinted.acquisto where id=?",id);
        return rowAffected>0;
    }


    public List<AcquistoModel> getAcquisti(){
        return this.db_vinted.query("select * from vinted.acquisto ORDER BY data_acquisto;",
                (rs, rowNum) ->
                        new AcquistoModel(
                                rs.getString("id"),
                                rs.getString("id_acquirente"),
                                rs.getString("id_articolo"),
                                rs.getString("modalita_spedizione"),
                                rs.getDate("data_acquisto").toLocalDate(),
                                rs.getDate("data_spedizione").toLocalDate()
                        )
        );
    }
    //Wishlist
    public boolean createWishlist(WishListModel w){
        int rowAffected = db_vinted.update("insert into vinted.wishlist(id,id_utente,nome) " +
                        "values (?,?,?)",
               w.getId(),w.getId_utente(), w.getNome() );
        return rowAffected>0;
    }

    public boolean removeWishlist(String id){
        int rowAffected = db_vinted.update("delete from vinted.wishlist where id=?",id);
        return rowAffected>0;
    }

    public boolean updateWishlist(WishListModel w){
        int rowAffected = db_vinted.update("update vinted.wishlist set nome=?",
                w.getNome());
        return rowAffected>0;
    }

    public List<WishListModel> getWishlist(){
        return this.db_vinted.query("select * from vinted.wishlist",
                (rs, rowNum) ->
                        new WishListModel(
                                rs.getString("id"),
                                rs.getString("id_utente"),
                                rs.getString("nome")
                        )
        );
    }

    //articolo
    public boolean createArticolo(ArticoloModel a){
        int rowAffected = db_vinted.update("insert into vinted.articolo(id,nome,descrizione,id_venditore,condizioni,data,luogo,prezzo) " +
                        "values (?,?,?,?,?,?,?,))",
                a.getId(),a.getNome(),a.getDescrizione(),a.getId_venditore(),a.getCondizioni(),a.getData_pubblicazione(),a.getLuogo(),a.getLuogo());
        return rowAffected>0;
    }

    public boolean removeArticolo(String id){
        int rowAffected = db_vinted.update("update vinted.articolo set in_vendita=false where id=?",id);
        return rowAffected>0;
    }

    public boolean updateArticolo(ArticoloModel a){
        int rowAffected = db_vinted.update("update vinted.articolo set nome=?,descrizione=?,id_venditore=?,condizioni=?,data=?,luogo=?,prezzo=? where id=?",
                a.getNome(),a.getDescrizione(),a.getId_venditore(),a.getCondizioni(),a.getData_pubblicazione(),a.getLuogo(),a.getPrezzo(),a.getId());
        return rowAffected>0;
    }

    public List<ArticoloModel> getArticoli(){
        return this.db_vinted.query("select * from vinted.articolo ORDER BY data_pubblicazione;",
                (rs, rowNum) ->
                        new ArticoloModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("descrizione"),
                                rs.getString("id_venditore"),
                                rs.getString("condizioni"),
                                rs.getString("luogo"),
                                rs.getDouble("prezzo"),
                                rs.getDate("data_pubblicazione").toLocalDate()
        ));
    }




}
