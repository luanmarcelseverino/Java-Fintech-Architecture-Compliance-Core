package br.com.luanmarcelseverino;
import java.time.LocalDateTime;

public class AuditoriaService {
    public static void registrarEvento(String usuario, String acao) {
        System.out.println(String.format("[AUDITORIA - %s] Usuário: %s | Ação: %s", 
            LocalDateTime.now().withNano(0), usuario, acao));
    }
}