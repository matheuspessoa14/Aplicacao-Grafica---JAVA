package br.senac.rj.banco.janelas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.senac.rj.banco.modelo.ParticipanteDAO;

public class JanelaParticipante {
    public static JFrame criarJanelaParticipante() {
        JFrame janela = new JFrame("Atualização de Participante");
        janela.setResizable(false);
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janela.setSize(500, 350);

        Container caixa = janela.getContentPane();
        caixa.setLayout(null);

        JLabel labelId = new JLabel("ID do Participante:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelTipoIngresso = new JLabel("Tipo do Ingresso:");

        labelId.setBounds(30, 30, 140, 20);
        labelNome.setBounds(30, 70, 140, 20);
        labelEmail.setBounds(30, 110, 140, 20);
        labelTelefone.setBounds(30, 150, 140, 20);
        labelTipoIngresso.setBounds(30, 190, 140, 20);

        JTextField jTextId = new JTextField();
        JTextField jTextNome = new JTextField();
        JTextField jTextEmail = new JTextField();
        JTextField jTextTelefone = new JTextField();
        JTextField jTextTipoIngresso = new JTextField();

        jTextId.setBounds(180, 30, 100, 20);
        jTextNome.setBounds(180, 70, 250, 20);
        jTextEmail.setBounds(180, 110, 250, 20);
        jTextTelefone.setBounds(180, 150, 250, 20);
        jTextTipoIngresso.setBounds(180, 190, 250, 20);

        jTextNome.setEnabled(false);
        jTextEmail.setEnabled(false);
        jTextTelefone.setEnabled(false);
        jTextTipoIngresso.setEnabled(false);

        JButton botaoConsultar = new JButton("Consultar");
        JButton botaoGravar = new JButton("Gravar");
        JButton botaoLimpar = new JButton("Limpar");

        botaoConsultar.setBounds(300, 30, 120, 20);
        botaoGravar.setBounds(100, 250, 100, 25);
        botaoLimpar.setBounds(260, 250, 100, 25);

        botaoGravar.setEnabled(false);

        janela.add(labelId);
        janela.add(labelNome);
        janela.add(labelEmail);
        janela.add(labelTelefone);
        janela.add(labelTipoIngresso);

        janela.add(jTextId);
        janela.add(jTextNome);
        janela.add(jTextEmail);
        janela.add(jTextTelefone);
        janela.add(jTextTipoIngresso);

        janela.add(botaoConsultar);
        janela.add(botaoGravar);
        janela.add(botaoLimpar);

        ParticipanteDAO participante = new ParticipanteDAO();

        botaoConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(jTextId.getText());

                    if (!participante.consultarParticipante(id)) {
                        JOptionPane.showMessageDialog(janela, "Participante não encontrado!");
                        jTextNome.setText("");
                        jTextEmail.setText("");
                        jTextTelefone.setText("");
                        jTextTipoIngresso.setText("");
                        jTextNome.setEnabled(false);
                        jTextEmail.setEnabled(false);
                        jTextTelefone.setEnabled(false);
                        jTextTipoIngresso.setEnabled(false);
                        botaoGravar.setEnabled(false);
                    } else {
                        jTextNome.setText(participante.getNome());
                        jTextEmail.setText(participante.getEmail());
                        jTextTelefone.setText(participante.getTelefone());
                        jTextTipoIngresso.setText(participante.getTipoIngresso());

                        jTextNome.setEnabled(true);
                        jTextEmail.setEnabled(true);
                        jTextTelefone.setEnabled(true);
                        jTextTipoIngresso.setEnabled(true);

                        botaoGravar.setEnabled(true);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Preencha o campo ID corretamente!");
                }
            }
        });

        botaoGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(janela, "Deseja salvar o participante?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    try {
                        String nome = jTextNome.getText().trim();
                        String email = jTextEmail.getText().trim();
                        String telefone = jTextTelefone.getText().trim();
                        String tipoIngresso = jTextTipoIngresso.getText().trim();

                        if (nome.isEmpty()) {
                            JOptionPane.showMessageDialog(janela, "Preencha o campo Nome.");
                            jTextNome.requestFocus();
                            return;
                        }

                        boolean sucesso;
                        boolean existe = false;

                        int id = -1;
                        try {
                            id = Integer.parseInt(jTextId.getText());
                            existe = participante.consultarParticipante(id);
                        } catch (NumberFormatException ex) {
                            // Não tem problema, vai cadastrar
                        }

                        if (!existe) {
                            sucesso = participante.cadastrarParticipante(nome, email, telefone, tipoIngresso);
                            if (sucesso)
                                JOptionPane.showMessageDialog(janela, "Participante cadastrado com sucesso!");
                            else
                                JOptionPane.showMessageDialog(janela, "Erro ao cadastrar participante.");
                        } else {
                            sucesso = participante.atualizarParticipante(id, nome, email, telefone, tipoIngresso);
                            if (sucesso)
                                JOptionPane.showMessageDialog(janela, "Participante atualizado com sucesso!");
                            else
                                JOptionPane.showMessageDialog(janela, "Erro ao atualizar participante.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(janela, "Erro ao salvar: " + ex.getMessage());
                    }
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextId.setText("");
                jTextNome.setText("");
                jTextEmail.setText("");
                jTextTelefone.setText("");
                jTextTipoIngresso.setText("");

                jTextNome.setEnabled(true);
                jTextEmail.setEnabled(true);
                jTextTelefone.setEnabled(true);
                jTextTipoIngresso.setEnabled(true);

                botaoGravar.setEnabled(true);
            }
        });

        return janela;
    }
}
