package Kauaprojeto.Sistema_agendamento.infrastructure.repository;

import Kauaprojeto.Sistema_agendamento.infrastructure.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.time.LocalDateTime;

    public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

        Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);


    @Transactional
        void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);


    List<Agendamento> findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento,String cliente);
    }