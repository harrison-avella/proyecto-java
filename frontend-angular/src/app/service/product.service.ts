import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
// service es como el enchufe, consume api rest para obtener datos
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  productURL = 'http://localhost:8080/api/product';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.productURL);
  }

  public detail(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.productURL}/detail/${id}`);
  }

  public detailName(name: string): Observable<Product> {
    return this.httpClient.get<Product>(`${this.productURL}/detail/${name}`);
  }

  public save(product: Product): Observable<any> {
    return this.httpClient.post<any>(`${this.productURL}/create/`, product);
  }

  public update(id: number, product: Product): Observable<any> {
    return this.httpClient.put<any>(`${this.productURL}/update/${id}`, product);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(`${this.productURL}/delete/${id}`);
  }
}
