package market;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.guilhermebrandao.dao.customer.CustomerDaoImpl;
import com.guilhermebrandao.dao.order.OrderDaoImpl;
import com.guilhermebrandao.domain.Customer;
import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.domain.enums.OrderStatus;
import com.guilhermebrandao.mapper.CustomerMapperImpl;
import com.guilhermebrandao.request.CustomerPostRequestBody;
import com.guilhermebrandao.service.CustomerService;


public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;
	
	@Mock
	private CustomerDaoImpl customerDao;

	@Mock
	private OrderDaoImpl orderDaoImpl;
	
	@Mock
	private CustomerMapperImpl customerMapper;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllSemExceptionTest() {
		//cenario
		Customer customer1 = new Customer(1l, "João", "joao@email.com", "11988887777", "teste123");
		List<Customer> customers = new ArrayList<Customer>(Arrays.asList(customer1));
		
		when(customerDao.findAll()).thenReturn(customers);

		//acao
		service.findAll();
		
		//validacao
//		verify(customerDao, times(1)).findAll();
		verify(customerMapper, times(1)).toCustomerResponse(Mockito.any(Customer.class));
	}
	
	@Test
	public void findByIdSemExceptionTest() {
		//cenario
		Customer customer1 = new Customer(1l, "João", "joao@email.com", "11988887777", "teste123");
		Order Order1 = new Order(1l, LocalDateTime.now(), OrderStatus.WAITING_PAYMENT);
		
		List<Order> orders = new ArrayList<Order>(Arrays.asList(Order1));
		
		when(customerDao.findById(Mockito.anyLong())).thenReturn(Optional.of(customer1));
		when(orderDaoImpl.findAllByCustomerId(Mockito.anyLong())).thenReturn(orders);
		
		//acao
		service.findById(Mockito.anyLong());
		
		//validacao
		verify(customerMapper, times(1)).toCustomerResponse(Mockito.any(Customer.class));		
	}
	
	@Test
	public void insertSemExceptionTest() {
		//cenario
		Customer customer1 = new Customer(1l, "João", "joao@email.com", "11988887777", "Teste@123");		
		
		when(customerMapper.toCustomer(Mockito.any(CustomerPostRequestBody.class))).thenReturn(customer1);
		when(customerDao.insert(Mockito.any(Customer.class))).thenReturn(Optional.of(customer1));
		
		//acao
		service.insert(Mockito.any(CustomerPostRequestBody.class));
		
		//validacao
		verify(customerMapper, times(1)).toCustomerResponse(Mockito.any(Customer.class));		
	}
}
