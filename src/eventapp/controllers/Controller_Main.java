/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.DAO.EventoDAO;
import eventapp.models.Evento;
import eventapp.util.SceneManager;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controller_Main implements Initializable {

    @FXML
    private TableView<Evento> tableViewEvents;
    @FXML
//    private TableColumn id_evento;
//    @FXML
    private TableColumn nome_evento;
    @FXML
    private TableColumn dataIni_evento;
    @FXML
    private TableColumn dataFim_evento;
    @FXML
    private TableColumn local_evento;
    @FXML
    private TableColumn responsavel_evento;
    @FXML
    private TableColumn descricao_evento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            buscarEventosDaSemana();
        } catch (ParseException ex) {
            Logger.getLogger(Controller_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 
    public void buscarEventosDaSemana() throws ParseException{
        //estabelecendo um formato para data a ser passada ao banco
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        //capturando o inicio e o fim da semana
        Calendar cal = Calendar.getInstance();
        String dataStr = df.format(cal.getTime());
        //convertendo data String para o tipo do banco de dados
        java.sql.Date data = new java.sql.Date(df.parse(dataStr).getTime());
        //puxando dados para construção da tabela
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarPorData(data);
        if (lista != null) {
            nome_evento.setCellValueFactory(new PropertyValueFactory<>("nome"));
            dataIni_evento.setCellValueFactory(new PropertyValueFactory<>("data_inicio"));
            dataFim_evento.setCellValueFactory(new PropertyValueFactory<>("data_fim"));
            local_evento.setCellValueFactory(new PropertyValueFactory<>("local_evento"));
            responsavel_evento.setCellValueFactory(new PropertyValueFactory<>("id_criador"));
            descricao_evento.setCellValueFactory(new PropertyValueFactory<>("descricao"));

            tableViewEvents.setItems(FXCollections.observableArrayList(lista));
        } else {
            SceneManager.getInstance().alertMsg("ERRO", "Algo inesperado aconteceu", "Não foi possivel carregar os eventos", Alert.AlertType.ERROR);
        }
    }
}