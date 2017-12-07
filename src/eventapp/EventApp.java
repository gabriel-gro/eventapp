package eventapp;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;
import eventapp.util.SceneManager;
import eventapp.util.Conn;
import eventapp.util.Seguranca;
import eventapp.DAO.UsuarioDAO;
import eventapp.DAO.EventoDAO;
import eventapp.models.Usuario;
import eventapp.models.Evento;
import java.util.ArrayList;

public class EventApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sManager = SceneManager.getInstance();
        Scene cena = sManager.loadScene("Scene_Login");
        if (cena != null) {
            sManager.setPrimaryScene(cena);
        }
    }

    public static void main(String[] args) {
        launch(args);
        Conn con = new Conn();
        con.conectar();
        
        UsuarioDAO dao = new UsuarioDAO();
        EventoDAO daoEvento = new EventoDAO();
        
        /* ### Métodos para testar o programa ### */ 
        
        /* ### Novo usuário ### */ 
        
//        try{
//            Usuario usu = new Usuario("João","jobel5","jobel5@bol.com.br","12345","12345");
//            dao.insere(usu);
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        
//        Seguranca seg = Seguranca.getInstance();
//        
//        if(seg.logar("jobel5","12345")){
//            System.out.println("Sucesso!");
//        } else {
//            System.out.println("Fracasso");
//        }
        
        
        
        
        /* ### Novo Evento ### */ 
        
        /*
        try{
            //String nome, String descricao, String dataInicio, String dataFim, int idUsuario, String local
            Evento env = new Evento("Semana de Tecnologia da Informação", "Evento de tecnologia","22/10/2017","28/10/2018",2,"UFLA");
            System.out.println("kkk");
            daoEvento.insere(env);
        } catch (Exception e){
            System.out.println(e);
        }*/
        
        
        /* ### Listar eventos ### */
        
        /*ArrayList<Evento> eventos = new ArrayList();
        eventos = daoEvento.listar();
        for (Evento e : eventos) {
            e.imprimeEvento();
        }*/
        
        /* ### Deletar eventos ### */
        //daoEvento.deletar(2);
        
        /* ### Editar eventos ### */
        /*Evento env = new Evento("Semana de Tecnologia da Informação 2", "Evento de Empreendedorismo","23/10/2017","28/11/2018",2,"UFLA");
        env.setId(1);
        daoEvento.atualizar(env);*/
        
        /* ### Buscar por id ### */
        /*Evento env = daoEvento.procurarPorId(1);
        env.imprimeEvento();*/
        
        /* ### Buscar por nome ### */
        /*ArrayList<Evento> eventos = new ArrayList();
        eventos = daoEvento.buscarPorNome("semana");
        for (Evento e : eventos) {
            e.imprimeEvento();
        }*/
 
    }
    
}
