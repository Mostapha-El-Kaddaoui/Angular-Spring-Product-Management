import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  /*
  pour surmonter que l'app se bloque lorsque il 
  getAllProducts():Observable<any>{
    return this.http.get("http://localhost:8083/products");
  }*/

  apiUrl = "http://localhost:8083"
  getAllProducts():Observable<any>{
    return this.http.get(this.apiUrl+"/products");
  }
  deleteProduct(product:any){
    return this.http.delete(this.apiUrl+"/products/"+product.id);
  }

}
