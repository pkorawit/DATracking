package ccpsu.datracking.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by korawit on 6/20/2016.
 */
public class ItemTracking  extends BaseObservable {

    private String ItemID;
    private String CommittedDate;
    private String FiscalYear;
    private String Location;
    private String Owner;
    private String ConditionID;
    private String StatusID;
    private String VerifiedDate;
    private String Note;
    private String ImportSource;

    @Bindable
    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    @Bindable
    public String getCommittedDate() {
        return CommittedDate;
    }

    public void setCommittedDate(String committedDate) {
        CommittedDate = committedDate;
    }

    @Bindable
    public String getFiscalYear() {
        return FiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        FiscalYear = fiscalYear;
    }

    @Bindable
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Bindable
    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Bindable
    public String getConditionID() {
        return ConditionID;
    }

    public void setConditionID(String conditionID) {
        ConditionID = conditionID;
    }

    @Bindable
    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String statusID) {
        StatusID = statusID;
    }

    @Bindable
    public String getVerifiedDate() {
        return VerifiedDate;
    }

    public void setVerifiedDate(String verifiedDate) {
        VerifiedDate = verifiedDate;
    }

    @Bindable
    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Bindable
    public String getImportSource() {
        return ImportSource;
    }

    public void setImportSource(String importSource) {
        ImportSource = importSource;
    }

}


