package com.asiya.kootam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiya.kootam.model.Customer;
import com.asiya.kootam.model.LoginUser;
import com.asiya.kootam.model.Sale;
import com.asiya.kootam.model.SaleItem;
import com.asiya.kootam.model.Stock;
import com.asiya.kootam.model.StockItem;
import com.asiya.kootam.model.Vendor;
import com.asiya.kootam.service.CustomerService;
import com.asiya.kootam.service.LoginUserService;
import com.asiya.kootam.service.SaleItemService;
import com.asiya.kootam.service.SaleService;
import com.asiya.kootam.service.StockItemService;
import com.asiya.kootam.service.StockService;
import com.asiya.kootam.service.VendorService;


@Controller
public class KootamLoginController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private StockItemService stockItemService;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private SaleItemService saleItemService;
	
	@GetMapping("/kootam")
	public String login(Model model) {
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		
		return "kootamAsiya";
	}
	
	@GetMapping("/logOut")
	public String logOut(Model model) {
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		
		return "kootamAsiya";
	}
	
	 @GetMapping("/kootam/{luId}")
		public String kootamById(HttpSession session,@PathVariable ( value = "luId") int luId, Model model) {
			// create model attribute to bind form data
			
		 LoginUser loginUserIn=loginUserService.getLoginUserById(luId);
			
			session.setAttribute("luUserType", loginUserIn.getLuUserType());
			session.setAttribute("luId", loginUserIn.getLuId());
			model.addAttribute("loginUser", loginUserIn);
				return "home";
		}
	
	@PostMapping("/login/home")
	public String home(HttpSession session,@ModelAttribute("loginUser") LoginUser loginUser,Model model) {
		// save LoginUser to database

		//LoginUser loginUserIn=loginUserService.getLoginUserByPhone(loginUser.getLuPhone(), loginUser.getLuPassword());
		LoginUser loginUserIn=loginUserService.getLoginUserById(loginUser.getLuId(), loginUser.getLuPassword());
		
		session.setAttribute("luUserType", loginUserIn.getLuUserType());
		session.setAttribute("luId", loginUserIn.getLuId());
		model.addAttribute("loginUser", loginUserIn);
			return "home";
		
	}
	
	@GetMapping("/customerlistInfo")
	public String customerlistInfo( Model model)  {
		model.addAttribute("listCustomers", customerService.getAllCustomer());
		
		return "customerList";
		
	}
	
	
	
	@GetMapping("/vendorlistInfo")
	public String vendorlistInfo( Model model)  {
		model.addAttribute("listVendors", vendorService.getAllVendor());
	    return "vendorList";
		
	}
	
	
	
	@GetMapping("/loginUserlistInfo")
	public String loginUserlistInfo( Model model)  {
		model.addAttribute("listLoginUsers", loginUserService.getAllLoginUser());
	    return "loginUser_list";
		
	}
	
	
	
	@GetMapping("/salelist")
	public String saleItemlist( Model model)  {
		model.addAttribute("listSales", saleService.getAllSales());
	    return "sale_list";
		
	}
	
	
	
	@GetMapping("/stocklist")
	public String stockItemlist( Model model)  {
		model.addAttribute("listStocks", stockService.getAllStocks());
	    return "stock_list";
		
	}
	
	
	
	
	
	@GetMapping("/settings/{id}")
	public String settings( @PathVariable ( value = "id") int id,Model model)  {
		LoginUser loginUser=loginUserService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
		model.addAttribute("loginUser", loginUser);
		return "loginUser_update";
		
	}
	
	
	
	@GetMapping("/report")
	public String report( Model model)  {
		model.addAttribute("listStockItems", stockItemService.getAllStockItems());
		model.addAttribute("listSaleItems", saleItemService.getAllSaleItems());
		model.addAttribute("listVendors", vendorService.getAllVendor());
		model.addAttribute("listCustomers", customerService.getAllCustomer());
	    return "reportView";
		
	}
	
	
	@PostMapping("/customerCreatedAtDateReport")
    public String customerCreatedAtDateReport(@RequestParam("date") String date,Model model
    		                       ) throws ParseException  {
		SimpleDateFormat  sf=new SimpleDateFormat ("yyyy-mm-dd") ;
        Date localDate = sf.parse(date);
        System.out.println(date+":"+ localDate);
        List<Customer> customers=customerService.findCustomersOnDate(localDate);
        model.addAttribute("listCustomers", customers);
	    return "customerListReport";
    }
	
	@PostMapping("/vendorCreatedAtDateReport")
    public String vendorCreatedAtDateReport(@RequestParam("date") String date,Model model
    		                       ) throws ParseException  {
		SimpleDateFormat  sf=new SimpleDateFormat ("yyyy-mm-dd") ;
        Date localDate = sf.parse(date);
        System.out.println(date+":"+ localDate);
        List<Vendor> vendors=vendorService.findVendorsOnDate(localDate);
        model.addAttribute("listVendors", vendors);
	    return "vendorListReport";
    }
	
	@PostMapping("/saleCreatedAtDateReport")
    public String saleCreatedAtDateReport(@RequestParam("date") String date,Model model
    		                       ) throws ParseException  {
		SimpleDateFormat  sf=new SimpleDateFormat ("yyyy-mm-dd") ;
        Date localDate = sf.parse(date);
        System.out.println("*****************"+date+":"+ localDate);
        List<Sale> sales=saleService.findSalesOnDate(localDate);
        List<SaleItem> saleItems=new ArrayList<SaleItem>();
        for (Sale sale:sales) {
        	System.out.println("Loop*****************");
        	saleItems.addAll(sale.getSaleItems());
        }
        System.out.println("Out*****************");
        model.addAttribute("listSaleItems", saleItems);
	    return "saleItem_ListReport";
    }
	
	@PostMapping("/stockCreatedAtDateReport")
    public String stockCreatedAtDateReport(@RequestParam("date") String date,Model model
    		                       ) throws ParseException  {
		SimpleDateFormat  sf=new SimpleDateFormat ("yyyy-mm-dd") ;
        Date localDate = sf.parse(date);
        System.out.println(date+":"+ localDate);
        List<Stock> stocks=stockService.findStocksOnDate(localDate);
        List<StockItem> stockItems=new ArrayList<StockItem>();
        for (Stock stock:stocks) {
        	stockItems.addAll(stock.getStockItems());
        }
        model.addAttribute("listStockItems", stockItems);
	    return "stockItem_ListReport";
    }
	
	
}