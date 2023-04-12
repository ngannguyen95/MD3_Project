package ra.service.user;

import ra.model.Invoice;
import ra.service.admin.IGenericService;

import java.util.List;

public interface IInvoice extends IGenericService<Invoice> {
    List<Invoice> fillAllInvoiceByUserLogin();
}
