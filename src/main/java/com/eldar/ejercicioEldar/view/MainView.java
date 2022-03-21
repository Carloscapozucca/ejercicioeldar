package com.eldar.ejercicioEldar.view;

import com.eldar.ejercicioEldar.model.Tarjeta;
import com.eldar.ejercicioEldar.service.ITarjetaService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@PageTitle("MainView")
@Route
public class MainView extends ViewFrame {

    private ITarjetaService tarjetaService;
    private static Binder<Tarjeta> binder;
    private Grid<Tarjeta> grid;
    private Tarjeta tarjeta;
    private ListDataProvider<Tarjeta> dataProvider;
    private Dialog dialog;

    public MainView(ITarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
        setViewContent(createContent());
    }

    private Component createContent() {
        VerticalLayout layout = new VerticalLayout(createTarjeta(), createGrid());
        layout.setHeightFull();
        return layout;
    }

    private Component createTarjeta() {

        HorizontalLayout content = new HorizontalLayout();

        Button btnTarjeta = new Button(new Icon(VaadinIcon.PLUS));
        btnTarjeta.setText("Nueva Tarjeta");
        btnTarjeta.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        btnTarjeta.addClickListener(e -> createDialogLayout(tarjetaService, tarjeta));
        content.add(btnTarjeta);

        return content;
    }

    private Dialog createDialogLayout(ITarjetaService tarjetaService, Tarjeta tarjeta) {
        Dialog dialog = new Dialog();
        binder = new Binder<>();
        binder.setBean(tarjeta);
        dialog.getElement().setAttribute("aria-label", "Nueva tarjeta");

        H2 headline = new H2("Nueva Tarjeta");
        headline.getStyle().set("margin-top", "0");

        ComboBox<Tarjeta> comboBox = new ComboBox<>("Marca");
        comboBox.setItemLabelGenerator(Tarjeta::getMarca);
        TextField nroTarjeta = new TextField("Numero Tarjeta");
        TextField cardHolder = new TextField("CardHolder");
        TextField importe = new TextField("Importe");
        DateTimePicker fechaVencimiento = new DateTimePicker("Fecha Vencimiento");

        Button cancelButton = new Button("Cancelar", e -> dialog.close());
        Button saveButton = new Button("Añadir", e -> tarjetaService.saveTarjeta(tarjeta));
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, saveButton);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

        VerticalLayout dialogLayout = new VerticalLayout(headline, comboBox, nroTarjeta, cardHolder, importe,
                fechaVencimiento, buttonLayout);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");
        dialog.open();
        return dialog;
    }

    private Grid createGrid() {

        List<Tarjeta> listaTarjeta = new ArrayList<>();
        try {
            listaTarjeta = new ArrayList<>(tarjetaService.getTarjetas());
        } catch (Exception e) {
        }
        listaTarjeta.sort(Comparator.comparing(Tarjeta::getId));
        dataProvider = DataProvider.ofCollection(listaTarjeta);
        grid = new Grid<>();
        grid.setItems(dataProvider);
        grid.addItemDoubleClickListener(event -> showDetails(event.getItem()));
        grid.setHeightFull();

        grid.addColumn(Tarjeta::getMarca)
                .setFlexGrow(0)
                .setKey("marca")
                .setHeader("Marca")
                .setTextAlign(ColumnTextAlign.CENTER);

        grid.addColumn(Tarjeta::getNroTarjeta)
                .setFlexGrow(0)
                .setKey("nrotarjeta")
                .setHeader("Numero Tarjeta")
                .setTextAlign(ColumnTextAlign.CENTER);

        grid.addColumn(Tarjeta::getCardHolder)
                .setFlexGrow(0)
                .setKey("cardholder")
                .setHeader("CardHolder")
                .setTextAlign(ColumnTextAlign.CENTER);

        grid.addColumn(Tarjeta::getImporte)
                .setFlexGrow(0)
                .setKey("importe")
                .setHeader("Importe")
                .setTextAlign(ColumnTextAlign.CENTER);

        grid.addColumn(Tarjeta::getFechaVencimiento)
                .setFlexGrow(0)
                .setKey("fechavencimiento")
                .setHeader("Fecha Vencimiento")
                .setTextAlign(ColumnTextAlign.CENTER);

        grid.setWidthFull();

        return grid;
    }

    private void showDetails(Tarjeta tarjeta) {
        binder = new Binder<>();
        binder.setBean(tarjeta);

    }
}

