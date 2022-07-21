import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/services/auth.service';
import { TokenStorageService } from 'app/services/token-storage.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: any = {
    id: null,
    username: null,
    password: null,
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  responseText = '';
  roles: string[] = [];
  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService
  ) {}
  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }
  onSubmit(): void {
    const { id, username, password } = this.form;
    this.authService.login(id, username, password).subscribe(
      (data) => {
        console.log(data);
        this.tokenStorage.saveToken(data.authToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.responseText = 'Auth Token: ' + data.authToken;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
      },
      (err: { error: { message: string } }) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  reloadPage(): void {
    window.location.reload();
  }
}
