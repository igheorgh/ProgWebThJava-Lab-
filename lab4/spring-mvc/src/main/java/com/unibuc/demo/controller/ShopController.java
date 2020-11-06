package com.unibuc.demo.controller;

import com.unibuc.demo.domain.Shop;
import com.unibuc.demo.dto.ShopDto;
import com.unibuc.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping()
    public String getAll(Model model) {
        List<ShopDto> shopDtos = shopService.getAllShop();
        model.addAttribute("shopDtos", shopDtos);
        return "view-shops";
    }

    @GetMapping("/{cui}")
    public String getShopByCui(@PathVariable("cui") String cui, Model model) {
       ShopDto shopDto = shopService.getShopByCui(cui);
       model.addAttribute("shopDto", shopDto);
        return "view-shop";
    }

        @GetMapping("/view-create")
    public String viewCreate(ShopDto shopDto){

        return "add-shop";
    }

   @PostMapping("/create")
   public String createShop(ShopDto shopDtoi, Model model){
     shopService.createShop(shopDtoi);
      model.addAttribute("shopDtos", shopService.getAllShop());
       return "add-shop";
  }
    //Tema:
    //1.Implement the createShop method and the add-shop view.
    //2.Create an end-point to update(put) the shop (including adding new products) .

}
