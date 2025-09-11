package com.management.beneficiary.service;

import java.util.List;

public interface BeneficiaryService {


  BookResponseDTO create(AuthenticatedUser authenticatedUser, BookRequestDTO bookRequestDTO);

  BookResponseDTO findById(AuthenticatedUser authenticatedUser, Long id);

  List<BookResponseDTO> findAllByUser(AuthenticatedUser authenticatedUser);

  void deleteByIdAndUser(AuthenticatedUser authenticatedUser, Long id);

  BookResponseDTO updateByUser(AuthenticatedUser authenticatedUser, Long id, BookRequestDTO bookRequestDTO);

}
