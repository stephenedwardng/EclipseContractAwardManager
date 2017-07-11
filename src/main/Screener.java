package main;

import static behaviours.Status.EXPIRED;
import static behaviours.Status.PIPELINE;

/**
 * Created by user on 09/07/2017.
 */

public class Screener {

    Screenable supplier;
    Contract contract;

    public Screener(Screenable supplier) {
        this.supplier = supplier;
    }

    public Screener(Screenable supplier, Contract contract) {
        this.supplier = supplier;
        this.contract = contract;
    }

    public boolean checkExcluded() {
        if (supplier.isExclude() == 1) {
            return true;
        } else return false;
    }

    public boolean checkInsurance() {
        if (supplier.hasInsurance() == 1) {
            return true;
        } else return false;
    }

    public boolean checkCourtJudgement() {
        if (supplier.hasCourtJudgement() == 1) {
            return true;
        } else return false;
    }

    public boolean screenForEligibility() {
        if (checkExcluded() == false && checkInsurance() == true && checkCourtJudgement() == false) {
            return true;
        } else return false;
    }

    public boolean checkStatusOpenToSuppliers() {
        if (contract.getStatus() == PIPELINE || contract.getStatus() == EXPIRED) {
            return true;
        } else return false;
    }

}