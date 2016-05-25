package CONTROLADOR;

import CONTROLADOR.util.MobilePageController;
import ENTIDADES.Prestamo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "prestamoController")
@ViewScoped
public class PrestamoController extends AbstractController<Prestamo> {

    @Inject
    private UsuarioController userCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public PrestamoController() {
        // Inform the Abstract parent controller of the concrete Prestamo Entity
        super(Prestamo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        userCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetallePrestamo entities
     * that are retrieved from Prestamo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DetallePrestamo page
     */
    public String navigateDetallePrestamoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetallePrestamo_items", this.getSelected().getDetallePrestamoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detallePrestamo/index";
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUserCodigo(ActionEvent event) {
        if (this.getSelected() != null && userCodigoController.getSelected() == null) {
            userCodigoController.setSelected(this.getSelected().getUserCodigo());
        }
    }
}
