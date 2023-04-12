package ra.service.user;

import ra.config.Config;
import ra.model.Cart;
import ra.model.Invoice;
import ra.model.User;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceIMPL implements IInvoice {
    public static User userLogin = new UserServiceIMPL().getCurrentUser();
    public static List<Invoice> invoiceList = new Config<Invoice>().readFromFile(Config.PATH_INVOICE);


    @Override
    public List<Invoice> findAll() {
        return invoiceList;
    }

    @Override
    public void save(Invoice invoice) {
        if (findById(invoice.getIdInvoice())==null){
            invoiceList.add(invoice);
        }else {
            for (int i = 0; i < invoiceList.size(); i++) {
                if (invoiceList.get(i).getIdInvoice()==invoice.getIdInvoice()){
                    invoiceList.set(i,invoice);
                    break;
                }
            }
        }
        new Config<Invoice>().writerFile(Config.PATH_INVOICE,invoiceList);
    }

    @Override
    public Invoice findById(int id) {
        for (Invoice invoice : invoiceList
             ) {
            if (invoice.getIdInvoice()==id){
                return invoice;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Invoice> fillAllInvoiceByUserLogin() {
        List<Invoice> list = new ArrayList<>();
        for (Invoice invoice:invoiceList
             ) {
            if (invoice.getInvoiceUser().getUserId()== userLogin.getUserId()){
                list.add(invoice);
            }
        }
        return list;
    }
}
