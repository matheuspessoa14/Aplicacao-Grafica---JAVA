package br.senac.rj.banco.janelas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.senac.rj.banco.modelo.EventoDAO;

public class JanelaEvento {
    public static JFrame criarJanelaEvento() {
        JFrame janelaEvento = new JFrame("Atualização de Evento");
        janelaEvento.setResizable(false);
        janelaEvento.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janelaEvento.setSize(500, 400);

        Container caixa = janelaEvento.getContentPane();
        caixa.setLayout(null);

        // Labels
        JLabel labelId = new JLabel("ID do Evento:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelData = new JLabel("Data (YYYY-MM-DD):");
        JLabel labelLocal = new JLabel("Local:");
        JLabel labelDescricao = new JLabel("Descrição:");
        JLabel labelIdOrganizador = new JLabel("ID do Organizador:");

        labelId.setBounds(30, 30, 120, 20);
        labelNome.setBounds(30, 70, 120, 20);
        labelData.setBounds(30, 110, 150, 20);
        labelLocal.setBounds(30, 150, 120, 20);
        labelDescricao.setBounds(30, 190, 120, 20);
        labelIdOrganizador.setBounds(30, 230, 150, 20);

        // TextFields
        JTextField jTextId = new JTextField();
        JTextField jTextNome = new JTextField();
        JTextField jTextData = new JTextField();
        JTextField jTextLocal = new JTextField();
        JTextField jTextDescricao = new JTextField();
        JTextField jTextIdOrganizador = new JTextField();

        jTextId.setBounds(180, 30, 100, 20);
        jTextNome.setBounds(180, 70, 250, 20);
        jTextData.setBounds(180, 110, 150, 20);
        jTextLocal.setBounds(180, 150, 250, 20);
        jTextDescricao.setBounds(180, 190, 250, 20);
        jTextIdOrganizador.setBounds(180, 230, 100, 20);

        // Estados iniciais
        jTextNome.setEnabled(false);
        jTextData.setEnabled(false);
        jTextLocal.setEnabled(false);
        jTextDescricao.setEnabled(false);
        jTextIdOrganizador.setEnabled(false);

        // Botões
        JButton botaoConsultar = new JButton("Consultar");
        JButton botaoGravar = new JButton("Gravar");
        JButton botaoLimpar = new JButton("Limpar");

        botaoConsultar.setBounds(300, 30, 120, 20);
        botaoGravar.setBounds(100, 280, 100, 25);
        botaoLimpar.setBounds(260, 280, 100, 25);

        botaoGravar.setEnabled(false);

        // Adiciona os componentes à janela
        janelaEvento.add(labelId);
        janelaEvento.add(labelNome);
        janelaEvento.add(labelData);
        janelaEvento.add(labelLocal);
        janelaEvento.add(labelDescricao);
        janelaEvento.add(labelIdOrganizador);

        janelaEvento.add(jTextId);
        janelaEvento.add(jTextNome);
        janelaEvento.add(jTextData);
        janelaEvento.add(jTextLocal);
        janelaEvento.add(jTextDescricao);
        janelaEvento.add(jTextIdOrganizador);

        janelaEvento.add(botaoConsultar);
        janelaEvento.add(botaoGravar);
        janelaEvento.add(botaoLimpar);

        EventoDAO evento = new EventoDAO();

        botaoConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(jTextId.getText());
                    botaoGravar.setEnabled(true);
                    if (!evento.consultarEvento(id)) {
                        JOptionPane.showMessageDialog(janelaEvento, "Evento não encontrado!");
                        jTextNome.setText("");
                        jTextData.setText("");
                        jTextLocal.setText("");
                        jTextDescricao.setText("");
                        jTextIdOrganizador.setText("");
                    } else {
                        jTextNome.setText(evento.getNome());
                        jTextData.setText(evento.getData());
                        jTextLocal.setText(evento.getLocal());
                        jTextDescricao.setText(evento.getDescricao());
                        jTextIdOrganizador.setText(String.valueOf(evento.getIdOrganizador()));
                    }

                    jTextId.setEnabled(false);
                    jTextNome.setEnabled(true);
                    jTextData.setEnabled(true);
                    jTextLocal.setEnabled(true);
                    jTextDescricao.setEnabled(true);
                    jTextIdOrganizador.setEnabled(true);
                    botaoConsultar.setEnabled(false);
                    jTextNome.requestFocus();
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(janelaEvento, "Preencha o campo ID corretamente!");
                }
            }
        });

        botaoGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(janelaEvento, "Deseja salvar o evento?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    int id;
                    try {
                        id = Integer.parseInt(jTextId.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(janelaEvento, "ID do Evento inválido.");
                        jTextId.requestFocus();
                        return;
                    }
                    String nome = jTextNome.getText().trim();
                    String data = jTextData.getText().trim();
                    String local = jTextLocal.getText().trim();
                    String descricao = jTextDescricao.getText().trim();
                    int idOrganizador;

                    if (nome.isEmpty()) {
                        JOptionPane.showMessageDialog(janelaEvento, "Preencha o campo Nome.");
                        jTextNome.requestFocus();
                        return;
                    }

                    try {
                        idOrganizador = Integer.parseInt(jTextIdOrganizador.getText().trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(janelaEvento, "Preencha o campo ID do Organizador corretamente.");
                        jTextIdOrganizador.requestFocus();
                        return;
                    }

                    // Valida se o organizador existe antes de cadastrar/atualizar
                    if (!evento.existeOrganizador(idOrganizador)) {
                        JOptionPane.showMessageDialog(janelaEvento, "ID do Organizador não existe no sistema.");
                        jTextIdOrganizador.requestFocus();
                        return;
                    }

                    boolean existe = evento.consultarEvento(id);
                    boolean sucesso;
                    if (!existe) {
                        sucesso = evento.cadastrarEvento(nome, data, local, descricao, idOrganizador);
                        JOptionPane.showMessageDialog(janelaEvento,
                                sucesso ? "Evento cadastrado com sucesso!" : "Erro ao cadastrar evento.");
                    } else {
                        sucesso = evento.atualizarEvento(id, nome, data, local, descricao, idOrganizador);
                        JOptionPane.showMessageDialog(janelaEvento,
                                sucesso ? "Evento atualizado com sucesso!" : "Erro ao atualizar evento.");
                    }
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextId.setText("");
                jTextNome.setText("");
                jTextData.setText("");
                jTextLocal.setText("");
                jTextDescricao.setText("");
                jTextIdOrganizador.setText("");

                jTextId.setEnabled(true);
                jTextNome.setEnabled(false);
                jTextData.setEnabled(false);
                jTextLocal.setEnabled(false);
                jTextDescricao.setEnabled(false);
                jTextIdOrganizador.setEnabled(false);

                botaoConsultar.setEnabled(true);
                botaoGravar.setEnabled(false);
                jTextId.requestFocus();
            }
        });

        return janelaEvento;
    }
}
