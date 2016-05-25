package CONTROLADOR;

import CONTROLADOR.util.MobilePageController;
import ENTIDADES.DetallePrestamo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detallePrestamoController")
@ViewScoped
public class DetallePrestamoController extends AbstractController<DetallePrestamo> {

    @Inject
    private DetalleBiblioFacuController dtbfCodigoController;
    @Inject
    private PrestamoController presCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DetallePrestamoController() {
        // Inform the Abstract parent controller of the concrete DetallePrestamo Entity
        super(DetallePrestamo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        dtbfCodigoController.setSelected(null);
        presCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the DetalleBiblioFacu controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDtbfCodigo(ActionEvent event) {
        if (this.getSelected() != null && dtbfCodigoController.getSelected() == null) {
            dtbfCodigoController.setSelected(this.getSelected().getDtbfCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Prestamo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePresCodigo(ActionEvent event) {
        if (this.getSelected() != null && presCodigoController.getSelected() == null) {
            presCodigoController.setSelected(this.getSelected().getPresCodigo());
        }
    }
}
