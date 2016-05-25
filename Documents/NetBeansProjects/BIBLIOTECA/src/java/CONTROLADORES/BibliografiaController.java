package CONTROLADORES;

import CONTROLADORES.util.MobilePageController;
import ENTIDADES.Bibliografia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "bibliografiaController")
@ViewScoped
public class BibliografiaController extends AbstractController<Bibliografia> {

    @Inject
    private AreaController areaCodigoController;
    @Inject
    private AutorController autorCodigoController;
    @Inject
    private TipoBibliografiaController tibiCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public BibliografiaController() {
        // Inform the Abstract parent controller of the concrete Bibliografia Entity
        super(Bibliografia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        areaCodigoController.setSelected(null);
        autorCodigoController.setSelected(null);
        tibiCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleBiblioFacu
     * entities that are retrieved from Bibliografia?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DetalleBiblioFacu page
     */
    public String navigateDetalleBiblioFacuCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleBiblioFacu_items", this.getSelected().getDetalleBiblioFacuCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalleBiblioFacu/index";
    }

    /**
     * Sets the "selected" attribute of the Area controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAreaCodigo(ActionEvent event) {
        if (this.getSelected() != null && areaCodigoController.getSelected() == null) {
            areaCodigoController.setSelected(this.getSelected().getAreaCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Autor controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAutorCodigo(ActionEvent event) {
        if (this.getSelected() != null && autorCodigoController.getSelected() == null) {
            autorCodigoController.setSelected(this.getSelected().getAutorCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoBibliografia controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTibiCodigo(ActionEvent event) {
        if (this.getSelected() != null && tibiCodigoController.getSelected() == null) {
            tibiCodigoController.setSelected(this.getSelected().getTibiCodigo());
        }
    }
}
