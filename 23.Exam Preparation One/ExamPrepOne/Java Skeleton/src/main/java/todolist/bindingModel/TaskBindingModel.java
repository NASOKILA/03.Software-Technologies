package todolist.bindingModel;

public class TaskBindingModel {

	//TODO:Implement me...

    // Binding modela e neshto koeto polzvame kogato nqkoi ni e pratil nqkakvi danni i nie iskame da gi obrabotim

    // TOZI MODEL E SUSHTIQ KATO TASK SAMOCHE E S RAZLICHNO IME I NQMA ANOTACII
    // SHTE GO POLZVAME ZA DA GO PULNIM S DANNI OT USERA I DA PRASHTAME V MODELA


    // NQMA NUJDA OT ID

    private String title;
    private String comments;

    public TaskBindingModel() {
    }


    public TaskBindingModel(String title, String comments) {
        this.title = title;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
