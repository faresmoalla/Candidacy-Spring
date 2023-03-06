package pi.app.estatemarket.Services;

import pi.app.estatemarket.Entities.Contract;

import javax.annotation.Resource;

public interface PDfImpl {
    Resource generatePdf(Contract contract);
}
