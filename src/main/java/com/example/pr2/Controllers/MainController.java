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
import java.util.Optional;

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

    @Autowired
    private PersonOrdersRepository personOrdersRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private PostCommentsRepository postCommentRepository;



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

    @GetMapping("/PersonOrders")
    public String showPersonOrders(Model model) {
        List<PersonOrders> personOrders = personOrdersRepository.findAll();
        List<Person> persons = personRepository.findAll();
        List<Order> orders = orderRepository.findAll();

        model.addAttribute("personOrders", personOrders);
        model.addAttribute("persons", persons);
        model.addAttribute("orders", orders);

        return "personOrders";
    }

    @PostMapping("/addPersonOrder")
    public String addPersonOrder(@RequestParam int personId, @RequestParam int orderId) {
        Person person = personRepository.getById(personId);
        Order order = orderRepository.getById(orderId);

        PersonOrders personOrder = new PersonOrders();
        personOrder.setPerson(person);
        personOrder.setOrder(order);

        personOrdersRepository.save(personOrder);

        return "redirect:/PersonOrders";
    }

    @GetMapping("/deletePersonOrder/{id}")
    public String deletePersonOrder(@PathVariable int id) {
        personOrdersRepository.deleteById(id);
        return "redirect:/PersonOrders";
    }

    @GetMapping("/editPersonOrder/{id}")
    public String showEditPersonOrderForm(@PathVariable int id, Model model) {
        Optional<PersonOrders> personOrder = personOrdersRepository.findById(id);
        List<Person> persons = personRepository.findAll();
        List<Order> orders = orderRepository.findAll();

        personOrder.ifPresent(p -> model.addAttribute("personOrder", p));
        model.addAttribute("persons", persons);
        model.addAttribute("orders", orders);

        return "editPersonOrder";
    }

    @PostMapping("/editPersonOrder/{id}")
    public String editPersonOrder(@PathVariable int id, @RequestParam int personId, @RequestParam int orderId) {
        Optional<PersonOrders> optionalPersonOrder = personOrdersRepository.findById(id);
        Person person = personRepository.getById(personId);
        Order order = orderRepository.getById(orderId);

        if (optionalPersonOrder.isPresent()) {
            PersonOrders personOrder = optionalPersonOrder.get();
            personOrder.setPerson(person);
            personOrder.setOrder(order);
            personOrdersRepository.save(personOrder);
        }

        return "redirect:/PersonOrders";
    }

    @GetMapping("/OrderDetails")
    public String showOrderDetails(Model model) {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("orders", orders);
        return "OrderDetails";
    }

    @PostMapping("/addOrderDetail")
    public String addOrderDetail(@RequestParam int orderId, @RequestParam String details) {
        Order order = orderRepository.getById(orderId);
        OrderDetails orderDetail = new OrderDetails();
        orderDetail.setOrder(order);
        orderDetail.setDetails(details);
        orderDetailsRepository.save(orderDetail);
        return "redirect:/OrderDetails";
    }

    @GetMapping("/editOrderDetail/{id}")
    public String showEditOrderDetailForm(@PathVariable int id, Model model) {
        Optional<OrderDetails> orderDetail = orderDetailsRepository.findById(id);
        List<Order> orders = orderRepository.findAll();
        orderDetail.ifPresent(o -> model.addAttribute("orderDetail", o));
        model.addAttribute("orders", orders);
        return "editOrderDetail";
    }

    @PostMapping("/editOrderDetail/{id}")
    public String editOrderDetail(@PathVariable int id, @RequestParam int orderId, @RequestParam String details) {
        Optional<OrderDetails> optionalOrderDetail = orderDetailsRepository.findById(id);
        Order order = orderRepository.getById(orderId);

        if (optionalOrderDetail.isPresent()) {
            OrderDetails orderDetail = optionalOrderDetail.get();
            orderDetail.setOrder(order);
            orderDetail.setDetails(details);
            orderDetailsRepository.save(orderDetail);
        }

        return "redirect:/OrderDetails";
    }

    @GetMapping("/deleteOrderDetail/{id}")
    public String deleteOrderDetail(@PathVariable int id) {
        orderDetailsRepository.deleteById(id);
        return "redirect:/OrderDetails";
    }

    @GetMapping("/postComments")
    public String showPostComments(Model model) {
        List<PostComments> comments = postCommentRepository.findAll();
        List<Post> posts = postRepository.findAll();

        model.addAttribute("comments", comments);
        model.addAttribute("posts", posts);

        return "PostComments";
    }

    @PostMapping("/addPostComment")
    public String addPostComment(@RequestParam(name = "post_id") int post_id, @RequestParam String commentText) {
        Post post = postRepository.getById(post_id);
        PostComments postComments = new PostComments();
        postComments.setPost(post);
        postComments.setCommentText(commentText);
        postCommentRepository.save(postComments);

        return "redirect:/postComments";
    }

    @GetMapping("/deletePostComment/{id}")
    public String deletePostComment(@PathVariable int id) {
        postCommentRepository.deleteById(id);
        return "redirect:/postComments";
    }

    @GetMapping("/editPostComment/{id}")
    public String showEditPostCommentForm(@PathVariable int id, Model model) {
        Optional<PostComments> comment = postCommentRepository.findById(id);

        if (comment.isPresent()) {
            List<Post> posts = postRepository.findAll();
            model.addAttribute("comment", comment.get());
            model.addAttribute("posts", posts);
            return "editPostComment";
        } else {

            return "redirect:/postComments";
        }
    }

    @PostMapping("/editPostComment/{id}")
    public String editPostComment(@PathVariable int id, @RequestParam(name = "postId") int postId, @RequestParam String commentText) {
        Optional<PostComments> optionalComment = postCommentRepository.findById(id);
        Optional<Post> post = postRepository.findById(postId);

        if (optionalComment.isPresent() && post.isPresent()) {
            PostComments comment = optionalComment.get();
            comment.setPost(post.get());
            comment.setCommentText(commentText);
            postCommentRepository.save(comment);
        }

        return "redirect:/postComments";
    }








}