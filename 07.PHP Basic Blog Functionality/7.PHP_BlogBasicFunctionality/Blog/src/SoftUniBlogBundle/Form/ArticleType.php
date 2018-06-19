<?php

namespace SoftUniBlogBundle\Form;

use SoftUniBlogBundle\Entity\Article;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ArticleType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('title',TextType::class)
            ->add('content', TextareaType::class);

        //titela ni e TextType i trqbva da e pod Symfony/Component... a ne Doctrine/DBAL...
        //contenta ni e ot tip TextArea
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        // opisvme si formulqra
        $resolver->setDefaults(
            [
                'data_class' => Article::class
            ]
        );
    }

    // TUK SEPOQVQVA EDINA getBlockPrefix() FUNKCIQ KOQTO E PO DOBRE DA Q MAHNEM
}
