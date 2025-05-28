package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.scrumapp.models.Epicas;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import com.scrumapp.services.EpicService;
import com.example.ProyectosService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.scrumapp.models.Proyectos;
import com.scrumapp.models.User;;


public class CuestionarioController {
    @FXML private ComboBox<Epicas> epicaComboBox;
    @FXML private Label featureLabel;
    @FXML private TextArea textoArea;


private final EpicService epicaService = new EpicService();
private final FeatureService featureService = new FeatureService();
private final ProyectosService proyectoService = new ProyectosService();

public void inicializarParaUsuario(User usuario) {
    Proyectos proyecto = proyectoService.obtenerProyectoPorUsuario(usuario.getId());

    if (proyecto != null) {
        List<Epicas> epicas = epicaService.obtenerEpicasPorProyecto(proyecto.getId());
        epicaComboBox.getItems().setAll(epicas);

        // Cargar features automáticamente al seleccionar una épica
        epicaComboBox.setOnAction(event -> {
            Epicas seleccionada = epicaComboBox.getValue();
            if (seleccionada != null) {
                List<Feature> features = featureService.obtenerFeaturesPorEpica(seleccionada.getId());

                if (!features.isEmpty()) {
                    Feature primeraFeature = features.get(0); // solo una
                    featureLabel.setText("Que backlog items cree que debería tener la feature: " + primeraFeature.getNombre() + "? \n Escriba el numero de puntos de esfuerzo que deberian tener");
                } else {
                    featureLabel.setText("Esta épica no tiene features registradas.");
                }
            }
        });
    } else {
        System.out.println("⚠ No se encontró proyecto para el usuario.");
    }
}

    @FXML
    private void exportarAPDF() {
        String contenido = textoArea.getText();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar como PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf"));
        fileChooser.setInitialFileName("contenido.pdf");

        File archivo = fileChooser.showSaveDialog(textoArea.getScene().getWindow());

        if (archivo != null) {
            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(archivo));
                document.open();
                document.add(new Paragraph(contenido));
                document.close();

                System.out.println("✅ PDF guardado correctamente en: " + archivo.getAbsolutePath());
            } catch (DocumentException | IOException e) {
                System.err.println("❌ Error al generar el PDF:");
                e.printStackTrace();
            }
        }
    }
@FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
