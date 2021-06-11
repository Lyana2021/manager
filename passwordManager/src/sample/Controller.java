package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBConnect;
import model.Story;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField passwordInput;
    public TableView<Story> tableView;
    public TextField usernameInput;
    public TextField sitenameInpute;
    public TextField categoryInput;
    public TextField coomentInput;
    public TextField dateInput;
    public TextField urlInput;
    public TableColumn<Story,String> userTable;
    public TableColumn<Story,String> passwordColumn;
    public TableColumn<Story,String> siteNameColumn;
    public TableColumn<Story,String> categoryColumn;
    public TableColumn<Story,String> commentColumn;
    public TableColumn<Story,String> dateColumn;
    public TableColumn<Story,String> urlColumn;

    public void addClicked(ActionEvent actionEvent) {
        try {
            DBConnect.updateDb("INSERT INTO bd.table (password,username,sitesName,category,comments,date,url) VALUES('" + passwordInput.getText() + "', '" + usernameInput.getText() + "', '" + sitenameInpute.getText() + "', '" + categoryInput.getText() + "','" + coomentInput.getText() + "','" + dateInput.getText() + "','" + urlInput.getText() + "') ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableView.setItems(DBConnect.getDataFromDb("SELECT * FROM bd.table;"));
            userTable.setCellValueFactory(new PropertyValueFactory<Story, String>("username"));
            passwordColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("password"));
            siteNameColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("sitename"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("category"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("date"));
            commentColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("comment"));
            urlColumn.setCellValueFactory(new PropertyValueFactory<Story, String>("siteURL"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
