package Model;
// Generated 6 mai 2018 18:06:59 by Hibernate Tools 4.3.1



/**
 * PrescriptionDetail generated by hbm2java
 */
public class PrescriptionDetail  implements java.io.Serializable {


    private int codeDetail;
    private String description;
    private Prescriptionentet prespection;

    public PrescriptionDetail() {
    }

    public PrescriptionDetail(int codeDetail, String description, Prescriptionentet Prespection) {
       this.codeDetail = codeDetail;
       this.description = description;
       this.prespection = Prespection;
      
    }
   
    public int getCodeDetail() {
        return this.codeDetail;
    }
    
    public void setCodeDetail(int codeDetail) {
        this.codeDetail = codeDetail;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Prescriptionentet getPrespection() {
        return prespection;
    }

    public void setPrespection(Prescriptionentet Prespection) {
        this.prespection = Prespection;
    }
  

}


