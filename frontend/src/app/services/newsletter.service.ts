import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Newsletter } from '../model/newsletter';  
 
@Injectable({
  providedIn: 'root'
})
export class NewsletterService {

  private apiUrl = 'http://localhost:8080/api/newsletter';  // URL del backend

  constructor(private http: HttpClient) { }

  // Metodo per ottenere tutte le email
  getAllEmails(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/emails`);
  }

  // Metodo per ottenere l'email tramite ID
  getEmailById(id: number): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/email/${id}`);
  }
  addEmail(email: string): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/email`, email, {
        headers: { 'Content-Type': 'application/json' }
    });
  }

  checkEmail(email: string): Observable<boolean> {
      return this.http.get<boolean>(`${this.apiUrl}/check-email`, {
          params: { email }
      });
  }

}
