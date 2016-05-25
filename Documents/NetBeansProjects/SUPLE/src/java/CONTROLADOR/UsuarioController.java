package CONTROLADOR;

import CONTROLADOR.util.MobilePageController;
import ENTIDADES.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private TipoUsuarioController tiusCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tiusCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Prestamo entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Prestamo page
     */
    public String navigatePrestamoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Prestamo_items", this.getSelected().getPrestamoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/prestamo/index";
    }

    /**
     * Sets the "selected" attribute of the TipoUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTiusCodigo(ActionEvent event) {
        if (this.getSelected() != null && tiusCodigoController.getSelected() == null) {
            tiusCodigoController.setSelected(this.getSelected().getTiusCodigo());
        }
    }
}
