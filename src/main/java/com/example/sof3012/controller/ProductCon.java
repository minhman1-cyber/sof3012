package com.example.sof3012.controller;
import com.example.sof3012.entity.Category;
import com.example.sof3012.entity.Product;
import com.example.sof3012.services.CategoryService;
import com.example.sof3012.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductCon", value = {
        "/product/hien-thi",
        "/product/them",
        "/product/xoa",
        "/product/viewSua",
        "/product/sua",
        "/product/view"
})
public class ProductCon extends HttpServlet {

    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/product/hien-thi":
                hienThi(request, response);
                break;
            case "/product/viewSua":
                viewSua(request, response);
                break;
            case "/product/view":
                xem(request, response);
                break;
            case "/product/xoa":
                xoa(request, response);
                break;
        }
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        productService.xoa(id);
        response.sendRedirect("/product/hien-thi");
    }

    private void viewSua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product p = productService.getProduct(id);
        List<Category> cate = categoryService.findAll();
        request.setAttribute("cateList", cate);
        request.setAttribute("p", p);
        request.getRequestDispatcher("/view2/suaProduct.jsp").forward(request, response);
    }

    private void xem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product p = productService.getProduct(id);

        request.setAttribute("p", p);
        request.getRequestDispatcher("/view2/viewProduct.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        String pageParam = request.getParameter("page");
        List<Category> cate = categoryService.findAll();

        int page = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
        int size = 5;

        List<Product> products;

        long total;

        if(keyword != null && !keyword.trim().isEmpty()) {
            products = productService.getProductByKeywordAndPage(keyword, page, size);
            total = productService.countProductByKeyword(keyword);
        }else{
            products = productService.getProductByPage(page, size);
            total = productService.countProduct();
            System.out.println("da chay vao truong hop 2 voi kich thuoc = " + products.size());
            System.out.println("Thong tin sp 1 = " + products.get(0).getCategory().getName());
        }

        int totalPage = (int) Math.ceil(total/(double)size);

        request.setAttribute("products", products);
        request.setAttribute("totalPages", totalPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("keyword", keyword);
        request.setAttribute("cateList", cate);
        request.getRequestDispatcher("/view2/ProductList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/product/them":
                them(request, response);
                break;
            case "/product/sua":
                sua(request, response);
                break;
        }
    }

    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Long idCate = Long.parseLong(request.getParameter("categoryName"));
        Category category = categoryService.findById(idCate);

        productService.sua(id, name, category);
        response.sendRedirect("/product/hien-thi");

    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Long idCate = Long.parseLong(request.getParameter("categoryName"));
        Category category = categoryService.findById(idCate);

        productService.them(id, name, category);
        response.sendRedirect("/product/hien-thi");
    }
}