package ra.controller.user;

import ra.model.Cart;
import ra.model.Invoice;
import ra.service.admin.ICartService;
import ra.service.user.IInvoice;
import ra.service.user.InvoiceServiceIMPL;

import java.util.List;

public class InvoiceController {
    private IInvoice invoiceService=new InvoiceServiceIMPL();
    // danh sách hóa đơn
    public List<Invoice> invoiceList=invoiceService.findAll();
    public void createInvoice(Invoice invoice){
        invoiceService.save(invoice);
    }
    public void updateInvoice(Invoice invoice){
        invoiceService.save(invoice);
    }
    public Invoice detailInvoice(int id){
        return invoiceService.findById(id);
    }
    public void deleteInvoice(int id){
        invoiceService.deleteById(id);
    }

}
