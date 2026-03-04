package Kauaprojeto.Sistema_agendamento.controller;

import Kauaprojeto.Sistema_agendamento.infrastructure.entity.Agendamento;
import Kauaprojeto.Sistema_agendamento.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamentos")

public class AgendamentoController {


    private final AgendamentoService agendamentoService;


    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente, @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();


    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosDia(LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }


    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamentos(@RequestBody Agendamento agendamento, @RequestParam String cliente, @RequestParam LocalDateTime dataHoraAgendamento){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }


}

