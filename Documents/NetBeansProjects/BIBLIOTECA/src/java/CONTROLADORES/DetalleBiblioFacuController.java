package CONTROLADORES;

import CONTROLADORES.util.MobilePageController;
import ENTIDADES.DetalleBiblioFacu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleBiblioFacuController")
@ViewScoped
public class DetalleBiblioFacuController extends AbstractController<DetalleBiblioFacu> {

    @Inject
    private BibliografiaController biblCodigoController;
    @Inject
    private FacultadController facuCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DetalleBiblioFacuController() {
        // Inform the Abstract parent controller of the concrete DetalleBiblioFacu Entity
        super(DetalleBiblioFacu.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        biblCodigoController.setSelected(null);
        facuCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetallePrestamo entities
     * that are retrieved from DetalleBiblioFacu?cap_first and returns the
     * navigation outcome.
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
     * Sets the "selected" attribute of the Bibliografia controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareBiblCodigo(ActionEvent event) {
        if (this.getSelected() != null && biblCodigoController.getSelected() == null) {
            biblCodigoController.setSelected(this.getSelected().getBiblCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Facultad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFacuCodigo(ActionEvent event) {
        if (this.getSelected() != null && facuCodigoController.getSelected() == null) {
            facuCodigoController.setSelected(this.getSelected().getFacuCodigo());
        }
    }
}
