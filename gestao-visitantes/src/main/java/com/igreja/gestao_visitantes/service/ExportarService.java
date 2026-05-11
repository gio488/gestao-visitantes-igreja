package com.igreja.gestao_visitantes.service;

import com.igreja.gestao_visitantes.model.Familiar;
import com.igreja.gestao_visitantes.model.Visitante;
import com.igreja.gestao_visitantes.repository.VisitanteRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExportarService {

    @Autowired
    private VisitanteRepository repository;

    public byte[] exportarParaExcel() throws IOException {
        LocalDate hoje = LocalDate.now();
        LocalDate ultimoDomingo = hoje.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        List<Visitante> todosVisitantes = repository.findAll();
        List<Visitante> visitantesDaSemana = todosVisitantes.stream()
                .filter(v -> v.getDataVisita() != null && !v.getDataVisita().isBefore(ultimoDomingo))
                .collect(Collectors.toList());

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Relatório do Culto");

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle boldStyle = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);
            boldStyle.setFont(boldFont);

            CellStyle highlightStyle = workbook.createCellStyle();
            highlightStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
            highlightStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            Row headerRow = sheet.createRow(0);
            String[] colunas = {"Nome / Parentesco", "Igreja", "Evangélico", "Data da Visita"};
            for (int i = 0; i < colunas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(colunas[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            int totalVisitantes = 0;
            int totalFamiliares = 0;

            for (Visitante v : visitantesDaSemana) {
                totalVisitantes++;
                Row row = sheet.createRow(rowNum++);


                if (!v.isEvangelico()) {
                    row.setRowStyle(highlightStyle);
                }

                Cell cellNome = row.createCell(0);
                cellNome.setCellValue(v.getNome());
                cellNome.setCellStyle(boldStyle);

                row.createCell(1).setCellValue(v.getNomeIgreja());
                row.createCell(2).setCellValue(v.isEvangelico() ? "Sim" : "Não");
                row.createCell(3).setCellValue(v.getDataVisita().toString());


                if (v.getFamiliares() != null) {
                    for (Familiar f : v.getFamiliares()) {
                        totalFamiliares++;
                        Row rowF = sheet.createRow(rowNum++);

                        String info = "   ↳ " + f.getNome() + (f.getParentesco() != null ? " (" + f.getParentesco() + ")" : "");
                        rowF.createCell(0).setCellValue(info);
                        rowF.createCell(1).setCellValue(f.getNomeIgreja() != null ? f.getNomeIgreja() : "-");
                        rowF.createCell(2).setCellValue(f.isEvangelico() ? "Sim" : "Não");
                        rowF.createCell(3).setCellValue("-");

                        if (!f.isEvangelico()) {

                            Cell c = rowF.getCell(0);
                            c.setCellStyle(highlightStyle);
                        }
                    }
                }
            }


            rowNum++;
            Row summaryRow = sheet.createRow(rowNum++);
            Cell summaryCell = summaryRow.createCell(0);
            summaryCell.setCellValue("RESUMO DO CULTO:");
            summaryCell.setCellStyle(headerStyle);

            Row totalRow = sheet.createRow(rowNum++);
            totalRow.createCell(0).setCellValue("Total de Visitantes: " + totalVisitantes);
            totalRow.createCell(1).setCellValue("Total de Familiares: " + totalFamiliares);
            totalRow.createCell(2).setCellValue("TOTAL GERAL: " + (totalVisitantes + totalFamiliares));


            for (int i = 0; i < colunas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}