package ra.service.user;

import ra.config.Config;
import ra.model.Cart;
import ra.model.Invoice;
import ra.model.User;

import java.util.List;

public class InvoiceServiceIMPL implements IInvoice {
    public static User userLogin = new UserServiceIMPL().getCurrentUser();
    //    public static List<Cart> cartList = userLogin.getCartList();
    public static List<Invoice> invoiceList = new Config<Invoice>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List<Invoice> findAll() {
        return invoiceList;
    }

    @Override
    public void save(Invoice invoice) {
//        if (findById(invoice.getIdInvoice())==null){
//            invoiceList.add(invoice);
//        }else {
//            for (int i = 0; i < invoiceList.size(); i++) {
//                if (invoiceList.get(i).getIdInvoice()==invoice.getIdInvoice()){
//                    invoiceList.set(i,invoice);
//                }
//            }
//        }
        invoiceList.add(invoice);
        new Config<Invoice>().writerFile(Config.PATH_INVOICE, invoiceList);
    }

    //tìm hóa đơn theo id
    @Override
    public Invoice findById(int id) {
        for (Invoice invoice : invoiceList) {
            if (invoice.getIdInvoice() == id) {
                return invoice;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
