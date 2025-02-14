import { Component, Renderer2, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { NewsletterService } from './services/newsletter.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],  // Importa moduli necessari
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [NewsletterService]  // NewsletterService fornito qui
})
export class AppComponent {
  title = 'ShowcaseDonkey';
  isMenuActive: boolean = false;
  successMessage: string | null = null;
  errorMessage: string | null = null;
  errorFormatMessage: string | null = null;
  emailTouched: boolean = false; // Traccia se l'input è stato modificato


  constructor(
    private renderer: Renderer2,
    private el: ElementRef,
    private router: Router,
    private newsletterService: NewsletterService
  ) {}

  goToPlayStore() {
    window.open('https://play.google.com/store', '_blank');
  }

  goToAppStore() {
    window.open('https://www.apple.com/app-store/', '_blank');
  }

  // Funzione per validare il formato dell'email
  isEmailValid(email: string): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{3,}$/;
    this.errorFormatMessage = 'Inserisci un\'email valida nel formato corretto (es. nome@dominio.com).';
    return emailPattern.test(email);
  }
  // Metodo per controllare se l'email è già registrata
  checkMail(email: string) {
    if (email) {
      this.newsletterService.checkEmail(email).subscribe(
        (exists) => {
          if (exists) {
            this.errorMessage = 'Questa email è già stata registrata, prova con un account diverso';
            this.successMessage = null; // Cancella eventuali messaggi di successo
          } else {
            this.errorMessage = null; // Cancella eventuali messaggi di errore
            this.addMail(email);
          }
        },
        (error) => {
          console.error('Errore nel controllo dell\'email:', error);
          this.errorMessage = 'Si è verificato un errore durante la verifica dell\'email';
          this.successMessage = null;
        }
      );
    }
  }

  // Metodo per aggiungere l'email se non è già presente
  addMail(email: string) {
    this.newsletterService.addEmail(email).subscribe(
      () => {
        this.successMessage = 'Email aggiunta con successo';
        this.errorMessage = null; // Cancella eventuali messaggi di errore
      },
      (error) => {
        console.error('Errore durante l\'aggiunta dell\'email:', error);
        this.errorMessage = 'Si è verificato un errore durante l\'aggiunta dell\'email';
        this.successMessage = null;
      }
    );
  }

    // Funzione chiamata quando l'input viene modificato
    onInputChange() {
      this.emailTouched = true;
    }


}
