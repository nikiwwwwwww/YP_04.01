package com.example.pr2.Controllers;

import com.example.pr2.Repository.*;
import com.example.pr2.dao.*;
import com.example.pr2.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private TypeDAO typeDAO;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/")
    public String Main(Model model) {
        return "Main";
    }

    @GetMapping("/Products")
    public String products(@RequestParam(name = "search", required = false) String search, Model model) {

        List<Product> products;

        if (StringUtils.hasText(search)) {
            products = productRepository.findByNameContaining(search);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);
        return "Products";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") double price) {
        int id = 0;
        Product product = new Product(id, name, description, price);
        productDAO.save(product);
        return "redirect:/Products";
    }

    @GetMapping("/editProduct/{id}")
    public String editProductForm(@PathVariable int id, Model model) {
        Product product = productDAO.show(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/editProduct/{id}")
    public String editProduct(@PathVariable int id, @ModelAttribute Product updatedProduct) {
        productDAO.update(id, updatedProduct);
        return "redirect:/Products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.delete(id);
        return "redirect:/Products";
    }



    @GetMapping("/Orders")
    public String Orders(@RequestParam(name = "search", required = false) String search, Model model) {

        List<Order> orders;

        if (StringUtils.hasText(search)) {
            orders = orderRepository.findByNameContaining(search);
        } else {
            orders = orderRepository.findAll();
        }

        model.addAttribute("orders", orders);
        return "Orders";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam("orderDate") Date date,
                             @RequestParam("name") String name,
                             @RequestParam("status") String status) {
        int id = 0;
        Order order = new Order(id, date, name, status);
        orderDAO.save(order);
        return "redirect:/Orders";
    }

    @GetMapping("/editOrder/{id}")
    public String editOrderForm(@PathVariable int id, Model model) {
        Order order = orderDAO.show(id);
        model.addAttribute("order", order);
        return "editOrder";
    }

    @PostMapping("/editOrder/{id}")
    public String editOrder(@PathVariable int id, @ModelAttribute Order updatedOrder) {
        orderDAO.update(id, updatedOrder);
        return "redirect:/Orders";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderDAO.delete(id);
        return "redirect:/Orders";
    }



    @GetMapping("/Persons")
    public String Persons(@RequestParam(name = "search", required = false) String search, Model model) {

        List<Person> persons;

        if (StringUtils.hasText(search)) {
            persons = personRepository.findByUsernameContaining(search);
        } else {
            persons = personRepository.findAll();
        }

        model.addAttribute("persons", persons);
        return "Persons";
    }

    @PostMapping("/addPerson")
    public String addOrder(@RequestParam("username") String username,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        int id = 0;
        Person person = new Person(id, username, email, password);
        personDAO.save(person);
        return "redirect:/Persons";
    }

    @GetMapping("/editPerson/{id}")
    public String editPersonForm(@PathVariable int id, Model model) {
        Person person = personDAO.show(id);
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/editPerson/{id}")
    public String editPerson(@PathVariable int id, @ModelAttribute Person updatedPerson) {
        personDAO.update(id, updatedPerson);
        return "redirect:/Persons";
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        personDAO.delete(id);
        return "redirect:/Persons";
    }





    @GetMapping("/Posts")
    public String Posts(@RequestParam(name = "search", required = false) String search, Model model) {

        List<Post> posts;

        if (StringUtils.hasText(search)) {
            posts = postRepository.findByNameContaining(search);
        } else {
            posts = postRepository.findAll();
        }

        model.addAttribute("posts", posts);
        return "Posts";
    }


    @PostMapping("/addPost")
    public String addPost(@RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("salary") double salary) {
        int id = 0;
        Post post = new Post(id, name, description, salary);
        postDAO.save(post);
        return "redirect:/Posts";
    }

    @GetMapping("/editPost/{id}")
    public String editPostForm(@PathVariable int id, Model model) {
        Post post = postDAO.show(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping("/editPost/{id}")
    public String editPost(@PathVariable int id, @ModelAttribute Post updatedPost) {
        postDAO.update(id, updatedPost);
        return "redirect:/Posts";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id) {
        postDAO.delete(id);
        return "redirect:/Posts";
    }



    @GetMapping("/Types")
    public String Types(@RequestParam(name = "search", required = false) String search, Model model) {

        List<Type> types;

        if (StringUtils.hasText(search)) {
            types = typeRepository.findByNameContaining(search);
        } else {
            types = typeRepository.findAll();
        }

        model.addAttribute("types", types);
        return "Types";
    }
    @PostMapping("/addType")
    public String addType(@RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("category") String category) {
        int id = 0;
        Type type = new Type(id, name, description, category);
        typeDAO.save(type);
        return "redirect:/Types";
    }

    @GetMapping("/editType/{id}")
    public String editTypeForm(@PathVariable int id, Model model) {
        Type type = typeDAO.show(id);
        model.addAttribute("type", type);
        return "editType";
    }

    @PostMapping("/editType/{id}")
    public String editType(@PathVariable int id, @ModelAttribute Type updatedType) {
        typeDAO.update(id, updatedType);
        return "redirect:/Types";
    }

    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable int id) {
        typeDAO.delete(id);
        return "redirect:/Types";
    }
}
