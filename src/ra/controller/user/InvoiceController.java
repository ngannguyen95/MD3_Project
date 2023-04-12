package ra.controller.user;

import ra.model.Cart;
import ra.model.Invoice;
import ra.model.User;
import ra.service.admin.ICartService;
import ra.service.user.IInvoice;
import ra.service.user.InvoiceServiceIMPL;

import java.util.List;

public class InvoiceController {
    private IInvoice invoiceService = new InvoiceServiceIMPL();


    // danh sách hóa đơn
   public  List<Invoice> findAll(){
       return invoiceService.findAll();
   }
   public List<Invoice> findAllByUserLogin(){
       return invoiceService.fillAllInvoiceByUserLogin();
   }
   public Invoice findById(int id){
       return invoiceService.findById(id);
   }
   public void create(Invoice invoice){
       invoiceService.save(invoice);

   }
   public void  update(Invoice invoice){
       invoiceService.save(invoice);
   }
}
