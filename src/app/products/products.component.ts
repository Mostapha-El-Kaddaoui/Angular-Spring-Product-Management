import { Component, OnInit } from '@angular/core';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { heroUsers } from '@ng-icons/heroicons/outline';
import { bootstrapCheck2Square, bootstrapXOctagon, bootstrapTrashFill } from '@ng-icons/bootstrap-icons';
import { ProductService } from '../services/product.service';
interface Product {
  id: number;
  name: string;
  price: number;
  selected: boolean;
}

@Component({
  selector: 'app-products',
  imports: [NgIcon],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css',
  standalone: true,
  viewProviders: [provideIcons({ heroUsers, bootstrapCheck2Square, bootstrapXOctagon, bootstrapTrashFill })]
})
export class ProductsComponent implements OnInit {
  products: any[] = [];
  constructor(private productService: ProductService){

  }
  ngOnInit(): void {
    this.getAllProducts()
  }
  getAllProducts(){
    this.productService.getAllProducts().subscribe({
      next : resp =>{
        this.products=resp
      },
      error : err =>{
        console.log("error getting the products")
      }
    })
  }
  handleDelete(product: any): void{
    let verify = confirm("etes vous sure ?")
    if (verify){
      this.productService.deleteProduct(product).subscribe({
        next : resp =>{
          this.getAllProducts()
        },
        error : err =>{
          console.log("error deleting the products")
        }
      })
    }
  }
}
